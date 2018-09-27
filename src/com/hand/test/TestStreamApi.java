package com.hand.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author ZhongLingYun
 * @Title: TestStreamApi
 * @Description: StreamApi练习
 * @date 2018/9/2711:18
 */
public class TestStreamApi {

    /**
     * @Description: 返回给定数的平方列表
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 11:26
     */
    @Test
    public void test(){
        List<Integer> list= Arrays.asList(
                1,2,3,4,5,6,7,8,9
        );
        list.stream().map(x->x*x).forEach(System.out::println);

        // 统计总数
        Optional<Integer> count= list.stream().map(e->1).reduce(Integer::sum);
        System.out.println(count.get());
    }
}
