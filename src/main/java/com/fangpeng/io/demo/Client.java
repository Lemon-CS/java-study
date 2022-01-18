package com.fangpeng.io.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 方鹏
 * @date 2022年01月17日 10:32 下午
 */
public class Client {

    public static void main(String[] args) {

        final String QUIT = "quit";
        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        Socket socket = null;
        BufferedWriter writer = null;

        try {
            // 创建socket
            socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);

            // 创建IO流
            HttpURLConnection conn;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 等待用户输入信息
            BufferedReader consoleReader =
                    new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String input = consoleReader.readLine();

                // 发送消息给服务器
                writer.write(input + "\n");
                writer.flush();

                // 读取服务器返回的消息
                String msg = reader.readLine();
                System.out.println(msg);

                // 查看用户是否退出
                if (QUIT.equals(input)) {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("关闭socket");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
