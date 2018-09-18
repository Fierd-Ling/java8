package com.hand.lamba;

/**
 * @author ZhongLingYun
 * @Title: MyPridict
 * @Description: TODO
 * @date 2018/9/1718:10
 */
    @FunctionalInterface
public interface MyPridiect<T> {

    /**
     * @Description: 判段
     * @param: [t]
     * @return: boolean
     * @auther: ZhongLingYun
     * @date: 2018/9/17 18:12
     */
    boolean pd(T t);// 函数式接口只能有一个抽象方法

}
