package com.ailot.netty.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ailot
 * @version ClientSocketDemo1.java, 2019年07月13日 下午8:41
 */
public class ClientSocketDemo1 {

    public static void main(String[] args) {
        try {
            //找到目标的ip和端口
            Socket socket = new Socket("localhost", 8080);

            //在当前链接上写入输入
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //控制台的输入流
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //拿到输入流
            BufferedReader in = new BufferedReader(new InputStreamReader
                    (socket.getInputStream()));

            String readline = sin.readLine(); //获得控制台的输入
            while (!readline.equals("bye")) {
                out.println(readline);

                System.out.println("Server:" + in.readLine());
                readline = sin.readLine(); //重新获取
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
