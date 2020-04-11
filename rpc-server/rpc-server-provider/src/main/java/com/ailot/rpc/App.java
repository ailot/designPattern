package com.ailot.rpc;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        IHelloService iHelloService = new IHelloServiceImpl();
       RpcProxyServer proxyServer = new RpcProxyServer();
       proxyServer.publisher(iHelloService,8080);
    }
}
