package com.ailot.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ailot
 * @version BIOServer.java, 2019年07月11日 下午12:42
 */
public class BIOServer {

    ServerSocket server;
    public BIOServer(int port) {

        try {
            server = new ServerSocket(port);
            System.out.println("BIO服务启动了，开始监听8080");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void listen() throws IOException {

        while (true){
            Socket socket = server.accept();

            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];

            int len = inputStream.read(bytes);
            if (len > 0){
                String str = new String(bytes,0,len);
                System.out.println("收到："+ str);
            }
            inputStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new BIOServer(8080).listen();
    }


}
