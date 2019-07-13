package com.ailot.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author ailot
 * @version BIOClient.java, 2019年07月11日 下午1:44
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost",8080);

        OutputStream outputStream = client.getOutputStream();

        String name = UUID.randomUUID().toString();

        System.out.println("客户端发送数据"+name);

        outputStream.write(name.getBytes());
        outputStream.close();
        client.close();
    }
}
