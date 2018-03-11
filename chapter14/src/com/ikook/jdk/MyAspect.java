package com.ikook.jdk;

/**
 * 切面类：可以存在多个通知 Advice(增强的方法内容)
 */
public class MyAspect {

    public void myBefore() {
        System.out.println("方法执行前");
    }

    public void myAfter() {
        System.out.println("方法执行后");
    }

}
