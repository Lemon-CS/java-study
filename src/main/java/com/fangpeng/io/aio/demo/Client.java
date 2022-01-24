package com.fangpeng.io.aio.demo;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 方鹏
 * @date 2022年01月19日 1:43 下午
 */
public class Client {

    final String LOCALHOST = "localhost";
    final int DEFAULT_PORT = 8888;
    AsynchronousSocketChannel clientChannel;

    private void close(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
                System.out.println("关闭" + closable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void start() {

        try {
            // 创建channel
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(LOCALHOST, DEFAULT_PORT));
            future.get(); // 阻塞式的调用

            // 等待用户的输入
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String input = consoleReader.readLine();

                byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
                ByteBuffer buffer = ByteBuffer.wrap(inputBytes);
                Future<Integer> writeResult = clientChannel.write(buffer);

                writeResult.get();
                buffer.flip();
                Future<Integer> readResult = clientChannel.read(buffer);

                readResult.get();
                String echo = new String(buffer.array());
                buffer.clear();

                System.out.println(echo);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close(clientChannel);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
