package com.hand.time;

import org.junit.Test;

import java.time.*;

/**
 * @author ZhongLingYun
 * @Title: NewTimeApi
 * @Description: Java8全新时间api
 * @date 2018/9/2815:02
 */
public class NewTimeApi {

    @Test
    public void test(){
        // java8 时间 LocalDateTime LocalDate LocalTime
        LocalDateTime localDateTime = LocalDateTime.now();// 当前的时间
        System.out.println(localDateTime);

        // 自己指定时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2014,9,4,1,0,0,0);
        System.out.println(localDateTime1);

        // 对应的时间数据
        System.out.println(localDateTime.getSecond());

        LocalDate localDate =LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }


    @Test
    public void test1(){
        // Instant 时间戳
        Instant instant = Instant.now();
        // Instant采用的是UTC时间
        System.out.println(instant.atOffset(ZoneOffset.ofHours(8)));
        // 获取时间戳
        System.out.println(instant.toEpochMilli());

        // Unix元年加上60秒
        System.out.println(Instant.ofEpochSecond(60));

    }

    @Test
    public void test3(){
        // 两个时间之间的计算
        LocalTime localDateTime = LocalTime.now();
        LocalTime localDateTime1 = LocalTime.of(1,1,1);
        System.out.println(Duration.between(localDateTime,localDateTime1).toHours());

        // 计算两个日期之间的
        LocalDate localDate  = LocalDate.now();
        LocalDate localDate1= LocalDate.of(1,2,3);
        System.out.println(Period.between(localDate1,localDate).getMonths());
    }



}
