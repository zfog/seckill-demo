package com.demo.seckill.test;

public class MyTest1 {

    private static int i = 0;

    public static void main(String[] args) {
        i = 1;
        System.out.println(i);
//        printMsg(123, 12.3, "a string", '1', 123123);
    }


    public static <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试：" + "t is -->" + t);
        }

    }
}
