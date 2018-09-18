package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ZhongLingYun
 * @Title: LambdaInterface
 * @Description: TODO
 * @date 2018/9/1816:28
 */
public class LambdaInterface {

// consumer
    public void consumer(String str, Consumer<String> consumer){
        //数据操作
        consumer.accept(str);
    }

    @Test
    public void testConcumer(){
        consumer("你好",s -> System.out.println(s+s));

    }

    // supplier
    public List<Integer> supplier(Supplier<Integer> supplierss){
        List<Integer> list= new ArrayList<>();
        for (int x=0;x<20;x++){
        list.add(supplierss.get());
        }
        return list;
    }

    @Test
    public void testSupplier(){
        List list=supplier(()-> (int)(Math.random()*1000));//采取强制 转
        list.forEach(System.out::println);
    }

    // predict 判断型接口
    public List<Student> predict(List<Student>list, Predicate<Student> predicate){
        List<Student> studentList = new ArrayList<>();
        for (Student stunde:list) {
            if(predicate.test(stunde)){
                studentList.add(stunde);
            }
        }
        return studentList;
    }

    @Test
    public void testPredict(){
        List<Student> studentList = Arrays.asList(
                new Student("王五",10,40),
                new Student("刘四",67,600),
                new Student("孙十",23,87),
                new Student("张三",20,700)
        );
        List<Student> list = predict(studentList,e->e.getAge()>20);
        list.forEach(System.out::println);
    }

    // function 接口 两进一出
    public Integer function(Integer L1,Function<Integer ,Integer> function){
        return function.apply(L1);
    }

    @Test
    public void testFunction(){
        Integer x=function(100,t->t+t);
        System.out.println(x);
    }


}

