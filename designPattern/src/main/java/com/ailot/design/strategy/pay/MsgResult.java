package com.ailot.design.strategy.pay;

/**
 * @author ailot
 * @version MsgResule.java, 2019年03月30日 上午11:21
 */
public class MsgResult {

    private int code;

    private Object data;

    private String msg;

    public MsgResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
