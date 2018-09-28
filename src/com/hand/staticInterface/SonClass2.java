package com.hand.staticInterface;

/**
 * @author ZhongLingYun
 * @Title: SonClass2
 * @Description: TODO
 * @date 2018/9/2810:34
 */
public class SonClass2 implements MyFunction,MyFunction2 {
    // 当同时的两个接口中有两个一样的默认方法必须重必须重写这个
    @Override
    public String getString() {
        return "强制重写";
    }
}
