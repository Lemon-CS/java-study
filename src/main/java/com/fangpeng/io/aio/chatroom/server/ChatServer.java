package com.fangpeng.io.aio.chatroom.server;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 方鹏
 * @date 2022年01月19日 4:04 下午
 */
public class ChatServer {

    private static final String LOCALHOST = "localhost";
    private static final int DEFAULT_PORT = 8888;
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;
    private static final int THREADPOOL_SIZE = 8;

    private AsynchronousServerSocketChannel serverChannel;
    private AsynchronousChannelGroup channelGroup;
    private List<ClientHandler> connectedClients;
    private Charset charset = Charset.forName("UTF-8");
    private int port;

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
        this.connectedClients = new ArrayList<>();
    }

    private boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    private void close(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getClientName(AsynchronousSocketChannel clientChannel) {
        int clientPort = -1;
        try {
            InetSocketAddress address = (InetSocketAddress) clientChannel.getRemoteAddress();
            clientPort = address.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "客户端[" + clientPort + "]";
    }

    private void addClient(ClientHandler handler) {
        connectedClients.add(handler);
        System.out.println(getClientName(handler.clientChannel) + "已连接");
    }

    private synchronized void removeClient(ClientHandler handler) {
        connectedClients.remove(handler);
        System.out.println(getClientName(handler.clientChannel) + "已断开");
        close(handler.clientChannel);
    }

    private String receive(ByteBuffer buffer) {
        CharBuffer charbuffer = charset.decode(buffer);
        return String.valueOf(charbuffer);
    }

    private void forwardMessage(AsynchronousSocketChannel clientChannel, String fwdMsg) {

        for (ClientHandler handler : connectedClients) {
            if (!clientChannel.equals(handler.clientChannel)) {
                try {
                    ByteBuffer buffer = charset.encode(getClientName(clientChannel) + ": " + fwdMsg);
                    handler.clientChannel.write(buffer, null, handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void start() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(THREADPOOL_SIZE);
            channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
            serverChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverChannel.bind(new InetSocketAddress(LOCALHOST, port));
            System.out.println("启动服务器，监听端口：" + port + "...");

            while (true) {
                serverChannel.accept(null, new AcceptHandler());
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(serverChannel);
        }
    }

    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            // 等待新的客户端连接
            if (serverChannel.isOpen()) {
                serverChannel.accept(null, this);
            }

            if (clientChannel != null && clientChannel.isOpen()) {
                ClientHandler handler = new ClientHandler(clientChannel);
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
                // 将新用户添加到在线用户列表
                addClient(handler);
                clientChannel.read(buffer, buffer, handler);
            }

        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("连接失败：" + exc);
        }
    }


    private class ClientHandler implements CompletionHandler<Integer, Object> {

        private AsynchronousSocketChannel clientChannel;

        public ClientHandler(AsynchronousSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer) attachment;
            if (buffer != null) {
                if (result <= 0) {
                    // 客户端异常
                    // 将该客户端从在线用户列表当中移除
                    System.out.println("客户端异常");
                    removeClient(this);

                } else {
                    buffer.flip();
                    String fwdMsg = receive(buffer);
                    System.out.println(getClientName(clientChannel) + ":" + fwdMsg);
                    forwardMessage(clientChannel, fwdMsg);
                    buffer.clear();

                    if (readyToQuit(fwdMsg)) {
                        // 将该客户端从在线用户列表当中移除
                        removeClient(this);
                        return;
                    }

                    // 持续监听该客户端channel的输入
                    clientChannel.read(buffer, buffer, this);
                }
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("服务器读取或转发信息失败：" + exc);
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }


}
