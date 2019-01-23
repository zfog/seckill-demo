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
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "server_error");
    public static CodeMsg BIND_ERROR = new CodeMsg(500100, "参数校验异常：%s");

    /**
     * 登陆模块异常 5002xx
     */
    public static CodeMsg SESSION_EROOR = new CodeMsg(0, "session不存在或已失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500201, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500202, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500203, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500204, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500205, "密码错误");

    /**
     * 商品模块异常 5003xx
     */


    /**
     * 订单模块异常 5004xx
     */

    /**
     * 秒杀模块异常 5005xx
     */
    public static CodeMsg SOLD_OUT = new CodeMsg(500501, "商品已售罄");
    public static CodeMsg REPEATABLE_SECKILL = new CodeMsg(500502, "不能重复秒杀");

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

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String msg = String.format(this.msg, args);
        return new CodeMsg(code, msg);
    }
}
