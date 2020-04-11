package com.ailot.rpc;

import java.lang.reflect.Proxy;

/**
 * @author ailot
 * @version RpcProxyClient.java, 2019年07月14日 上午11:28
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class<?>[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
