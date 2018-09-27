package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author ZhongLingYun
 * @Title: StreamApi
 * @Description: streamApi
 * @date 2018/9/26 10:48
 */
public class StreamApi {
    List<Student> studentList = Arrays.asList(
            new Student("王五",10,40),
            new Student("刘四",67,600),
            new Student("孙十",23,87),
            new Student("张三",20,700)
    );


  /**
   *  查找匹配
   */
    @Test
    public void test(){
        // allMatch 返回值是Boolean，查找stream中所有的对象中某一个属性与该属性对应
       boolean b= studentList.stream().allMatch(e->e.getName().equals("张三"));
       System.out.println(b);
       // anyMatch  只要有一个匹配就返回true
        boolean b2=studentList.stream().anyMatch(e->e.getName().equals("张三"));
        System.out.println(b2);
        // noneMatch 查看是否没有一个和当前的相等（只要有一个相等就返回false）
        boolean b3=studentList.stream().noneMatch(e->e.getName().equals("张三"));
        System.out.println(b3);
    }

    @Test
    /**
     *
     * 返回结果控制
     *
     * */
    public  void test2(){
        // 返回第一个
        // 按照年龄大小排序
     /*   studentList.sort((e1,e2)->e1.getAge().compareTo(e2.getAge()));
       Optional<Student> op= studentList.stream().findFirst();
       System.out.println(op.get());*/
        // p是并行流 s是串行流
        Optional<Student> op2= studentList/*.parallelStream().*/.stream().filter(e->e.getAge()>30).findAny();// 返回流中任意一个
        System.out.println(op2.get());
    }

    @Test
    public void test3(){
        // 返回流中的总数据
        Long x=studentList.stream().count();
        System.out.println(x);
        // 返回最大值
        Optional<Student> d= studentList.stream().max(/**依据规则返回最大值***/
                (e1,e2)->Integer.compare(e1.getGrade(),e2.getGrade()));
        System.out.println(d.get());

        // 最小值
        Optional<Student> f= studentList.stream().min((e1,e2)->Integer.compare(e1.getGrade(),e2.getGrade()));
        System.out.println(f.get());

    }



}
