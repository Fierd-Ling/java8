package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.Optional;

/**
 * @author ZhongLingYun
 * @Title: Optional
 * @Description: optional API
 * @date 2018/9/2719:28
 */
public class TestOptional {

    @Test
    public void test(){
        Optional<Student> f= Optional.of(new Student());
        System.out.println(f.get());
    }

    @Test
    public void test1(){
        //Optional<Student> op=Optional.of(null);此处直接使用会出现空指针异常
        Optional<Student> op=Optional.empty();// 直接创建的是的optional直接等于null
        //System.out.println(op.get()); // 不能直接通过get获取

    }

    @Test
    public void test2(){
        Optional<Student> op = Optional.ofNullable(null);// return value == null ? empty() : of(value);
        System.out.println(op);

        // 是否包含值
        System.out.println(op.isPresent());

    }


}
