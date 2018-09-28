package com.hand.staticInterface;

/**
 * @author ZhongLingYun
 * @Title: MyFunction
 * @Description: 默认方法
 * @date 2018/9/2810:22
 */
public interface MyFunction {

    // 接口中的默认方法
    default  String getString(){
        return "MyFunction";
    }

    // 接口中的静态方法
    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
