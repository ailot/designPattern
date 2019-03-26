
package com.ailot.design.delegate.simple;

/**
 * @author ailot
 * @version DelegateTest.java, 2019年03月26日 下午10:21
 */
public class DelegateTest {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.command("加密",new Leader());
    }
}
