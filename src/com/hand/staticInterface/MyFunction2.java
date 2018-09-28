package com.hand.staticInterface;

/**
 * @author ZhongLingYun
 * @Title: MyFunction2
 * @Description: 用于测试的接口
 * @date 2018/9/2810:27
 */
public interface MyFunction2 {

    default String getString(){
        return "MyFunction2";
    }
}
