package com.demo.seckill.result;

/**
 * 异常信息封装类
 */
public class CodeMsg {
    private int code;
    private String msg;

    /**
     * 服务器异常 5001xx
     */
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "serer_error");

    /**
     * 登陆模块异常 5002xx
     */


    /**
     * 商品模块异常 5003xx
     */


    /**
     * 订单模块异常 5004xx
     */

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
