package com.ailot.rpc;

/**
 * @author ailot
 * @version IHelloServiceImpl.java, 2019年07月14日 上午10:03
 */
public class IHelloServiceImpl  implements  IHelloService{
    @Override
    public String say(String content) {
        System.out.println("request in "+content);
        return "say hello" + content;
    }

    @Override
    public String save(User user) {
        System.out.println("request in" + user);
        return "SUCCESS";
    }
}
