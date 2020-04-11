package com.ailot.rpc;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        //iHelloService.say("你好");
        iHelloService.save(new User("张三","18"));
    }
}
