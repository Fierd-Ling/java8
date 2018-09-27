package com.hand.test;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @author ZhongLingYun
 * @Title: parallel
 * @Description: 并行流
 * @date 2018/9/2715:20
 */
public class Parallel {

    /**
     * @Description: 计算1000000000000000L
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 15:21
     */
    @Test
    public void test(){

        // 并行计算
        LongStream.rangeClosed(0,9000000000000000000L).parallel().reduce(0,
                Long::sum);

    }
}
