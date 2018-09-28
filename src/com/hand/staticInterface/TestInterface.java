package com.hand.staticInterface;

/**
 * @author ZhongLingYun
 * @Title: TestInterface
 * @Description: 用于测试Java8新特性的
 * @date 2018/9/2810:31
 */
public class TestInterface {

    public static void main(String[] args) {
        SonClass sonClass = new SonClass();
        // 当同时继承和实现接口中出现了同一个名字的方法默认是类优先
        System.out.println(sonClass.getString());

        SonClass2 sonClass2 = new SonClass2();
        System.out.println(sonClass2.getString());

    }

}
