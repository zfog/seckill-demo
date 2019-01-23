package com.demo.seckill.enums;

public enum OrderEnum {
    NEW("新建未支付", 0),PAY("已支付", 1),DELIVER("已发货", 2),RECEIVE("已收货", 3),REFUND("已退款", 4),COMPLETE("交易完成", 5);

    private String name;
    private int value;

    OrderEnum(String name, int value){
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
