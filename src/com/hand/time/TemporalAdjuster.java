package com.hand.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author ZhongLingYun
 * @Title: TemporalAdjuster
 * @Description: 时间矫正器
 * @date 2018/9/2817:00
 */
public class TemporalAdjuster {

    @Test
    public void test(){
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println(localDateTime);
        // 设置日期
        System.out.println(localDateTime.withDayOfMonth(10));

        // 下一日期
        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));

    }
}
