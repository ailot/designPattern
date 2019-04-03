package com.ailot.design.adapter.loginadapter;

/**
 * @author ailot
 * @version ResultMsg.java, 2019年03月31日 下午8:39
 */
public class ResultMsg {

    private int code;

    private Object data;

    private String msg;

    public ResultMsg(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static ResultMsg success(){
        return new ResultMsg(200,"登录成功","登录成功");
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
