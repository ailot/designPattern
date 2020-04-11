package com.ailot.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ailot
 * @version RpcProxyService.java, 2019年07月14日 上午10:50
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service,int port){

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true){
                Socket accept = serverSocket.accept();
                executorService.submit(new ProcessorHandler(accept,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
