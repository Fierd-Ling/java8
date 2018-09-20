package com.hand.stream;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZhongLingYun
 * @Title: TestStream
 * @Description: TODO
 * @date 2018/9/1920:44
 */
public class TestStream {

    @Test
    public void streamApi(){
        // stream的生成
//        List<String> list= new ArrayList<>();
//        list.add("rtyui");
//        list.add("rtyui");
//        list.add("rtyui");
//        list.add("rtyui");
//        list.add("rtyui");
//        list.add("rtyui");
//        Stream<String> d=list.stream();
//        d.forEach();
        //无限流
        Stream<Integer> stream=Stream.iterate(0,(x)->x+1);
        List<Integer> d= new ArrayList<>();
        stream.limit(10).forEach(System.out::println);

        // 无限流2
      /*  Stream<String> stream1= */
        // 产生随机数
      Stream.generate(()->Math.random()).forEach(System.out::println);
    }

    List<Student> studentList = Arrays.asList(
            new Student("王五",10,40),
            new Student("刘四",67,600),
            new Student("孙十",23,87),
            new Student("张三",20,700)
    );


    @Test
    public void testStream(){
       //  studentList.stream().filter(e->e.getAge()>20).forEach(System.out::print);
        studentList.stream().filter((e)->{
            System.out.println("123");
            return e.getAge()>20;
        }).limit(1).forEach(System.out::println);
    }


    @Test
    public void testSkip(){
        studentList.stream().forEach(System.out::println);
        System.out.println("..............取出前面两个........................");
        studentList.stream().limit(2).forEach(System.out::println);
        System.out.println("..............取出后面两个........................");
        studentList.stream().skip(2).forEach(System.out::println);
    }



}
