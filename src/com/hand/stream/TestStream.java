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
            new Student("张三",20,700),
            new Student("刘四",67,600),
            new Student("张三",20,700),
            new Student("刘四",67,600),
            new Student("刘四",67,600),
            new Student("张三",20,700),
            new Student("刘四",67,600),
            new Student("刘四",67,600),
            new Student("刘四",67,600)
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

    @Test// 去重操作
    public void testDistinct(){
        // distinct 需要重写hashCode和equals
        studentList.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void testMap(){
        // 拿到所有的名字然后去重
        studentList.stream().filter((e)->e.getAge()>20).map(Student::getName).distinct().forEach(System.out::println);
    }


    List<String> list= Arrays.asList(
            "dddd",
            "sss",
            "xxx",
            "defd",
            "dsdds"
    );

    /**
     * @Description:
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/20 18:36
     */
    @Test
    public void testFlatMap(){

        // 普通情况下map返回的是stream <T>
        Stream<Stream<Character>> streamStream=list.stream().map(TestStream::getCharacter);
        //streamStream.forEach((stream)->stream.forEach(System.out::println));
        streamStream.forEach(System.out::println);

        // flatMap 将流整合成一个流
        list.stream().flatMap(TestStream::getCharacter).forEach(System.out::println);



    }

    public static Stream<Character> getCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character character: str.toCharArray()) {
            list.add(character);
        }
        return list.stream();

    }

    @Test
    public void testAddAll(){
        List lists= new ArrayList<>();
        lists.add(list);
        lists.add("qw");
        lists.forEach(System.out::println);

        // addAll
        List d = new ArrayList();
        d.addAll(list);
        d.add("456789");
        d.forEach(System.out::println);

    }

    // 排序
    @Test
    public void px(){
        // 自然排序 按照字典排序
        list.forEach(System.out::println);
        System.out.println("--------------------------------");
        list.stream().sorted().forEach(System.out::println);
        // 自定义排序
        studentList.forEach(System.out::println);
        System.out.println("--------------------------------");
        studentList.stream().sorted((s1,s2)->{
            // sorted 排序操作
            if(s1.getAge().equals(s2.getAge())){
                //出现年龄 相等就按照找分数
                return s1.getAge().compareTo(s2.getGrade());
            }else {
                //首先按照年龄排序
                return s1.getAge().compareTo(s2.getAge());
            }
        }).forEach(System.out::println);

    }




}
