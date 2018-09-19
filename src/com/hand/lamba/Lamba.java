package com.hand.lamba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ZhongLingYun
 * @Title: Lamba
 * @Description: lamba表达式
 * @date 2018/9/1718:14
 */
public class Lamba {
    static List<Student> studentList = Arrays.asList(
           /* new Student("王五",10,40),
            new Student("刘四",67,600),
            new Student("孙十",23,87),
            new Student("张三",20,700)*/
    );

    // 筛选策略
    public static List<Student> choice(List<Student> list,MyPridiect<Student> myPridiect){
        List<Student> lists =  new ArrayList<Student>();
        for (Student student: list) {
            if(myPridiect.pd(student)){
                lists.add(student);
            }
        }
        return  lists;
    }


    // main 函数
    public static void main(String[] args) {
        //byAge();
        //lamba();
        test2();

    }

    /**
     * @Description: 通过年龄撒筛选
     * @param: []
     * @return: void
     * @auther: ZhongLingYun
     * @date: 2018/9/17 18:29
     */
    public static void byAge(){// age大于30
       /* List<Student> list=choice(studentList,student -> student.getAge()>20);
        list.forEach(System.out ::println);*/
        // 方法二 stream
        //studentList.stream().filter((e)->e.getAge()>20).limit(1).forEach(System.out::println);
        // limit限制数据条数，从第一条开始

        // 取出所有的名字
        studentList.stream()
                .map(Student::getName)//先变成string，然后用map封装，map里面只存名字
                .forEach(System.out::println);
    }

    public static void lamba(){
        int x=10;
        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println("123"+"--------"+x);
            }
        };
        r1.run();
        System.out.println("-----------------------------------");
        Runnable r2=()->System.out.print("456");
        r2.run();
    }

    public static void test(){
        // 只有一个参数小括号不写
        /*Consumer<String> consumer= (e)->System.out.print(e);
        consumer.accept("地方规划局快乐");*/
        // 多条参数
      /*  Comparator<Integer> consumer=(z, y) ->{//比较参数大小
            System.out.println("如下");
            return Integer.compare(z, y);
        };
        // 假如只有一条语句，大括号和return都可以不写
        System.out.println(consumer.compare(81,89));*/
      // 数据筛选 stream Api
        ///studentList.stream().filter((e)->e.getAge()>20).forEach(System.out::println);
        //studentList.stream().filter((e)->e.getName()=="张三").forEach(System.out::println);
        studentList.stream().filter((e)->e.getAge()>20).map(Student::getName).forEach(System.out::println);
    }

    /**
     * @Description: lambda表达式
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/18 11:15
     */
    public static void test2(){
        System.out.println(function(10,(x)->x*x));// 需要接口的支持
        System.out.print(function(300,(z)->++z*z));

    }

    // 接口实现函数
    public static Integer function(Integer x,MyInterface<Integer> myInterface){
        return myInterface.fu(x);
    }


}
