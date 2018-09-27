package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ZhongLingYun
 * @Title: Reduce
 * @Description: Java8中reduce
 * @date 2018/9/2620:01
 */
public class Reduce {

    List<Student> studentList = Arrays.asList(
                new Student("王五",170,40),
                new Student("刘四",67,6060),
                new Student("孙十",253,87),
                new Student("张三",20,7050),
                 new Student("邓九",240,40),
                 new Student("王五",120,404),
                new Student("刘四",657,6050),
                new Student("孙十",230,587),
                new Student("张三",11,12)
    );

    @Test
    public void test(){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // reduce 多个interface，此处使用的双参数第一个参数是起始值第二个是递归累加值
       Integer sum= list.stream().reduce(0,(x,y)->x+y);
       // reduce 第二个参数是二元运算
       System.out.println(sum);

       System.out.println("-------------------");
       // reduce统计分数总和，先拿出所有的分数然后在统计(count计算总个数)
        Optional<Integer> d= studentList.stream().map(e->e.getGrade()).reduce(Integer::sum);
        System.out.println("sum："+d.get());
    }

    /**
     *
     *
     * collect收集器
     *
     * **/
    @Test
    public void test1(){
        // 手收集所有的名字存到 list中
        studentList.stream().map(Student::getName).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------------");

        // 收集所有的名字去重
        studentList.stream().map(Student::getName).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println();
        //收集数据到特殊集合中去(new新的特殊集合)
        studentList.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
    }

    @Test
    public void test2(){
        // 平均值(年龄)
        Double x=studentList.stream().collect(Collectors.averagingDouble(Student::getAge));
        System.out.println(x);

        // 总和
        Integer d=studentList.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(d);

        // 最大值
        Optional<Student> f= studentList.stream().
                collect(Collectors.maxBy((e1,e2)->
                        Integer.compare(e1.getAge(),e2.getAge())));
        System.out.println(f.get());


        Optional<Student> h=studentList.stream().max((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()));
        System.out.println(h.get());

        // 最小值
        Optional<Student> t=studentList.stream().collect(Collectors.minBy((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())));
        System.out.println(t.get());

       Optional<Student> r= studentList.stream().min((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()));
        System.out.println(r.get());
    }


    /**
     * @Description: 分组
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/26 22:45
     */
    @Test
    public void test3(){
        // 按照name分组
       Map<String,List<Student>> dd=studentList.stream().collect(Collectors.groupingBy(Student::getName));
       System.out.println(dd);
    }

    /**
     * @Description: 分组，先按照姓名分然后按照年龄段分
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 9:04
     */
    @Test
    public void test4(){
        // 分组里面嵌套分组
        Map<String,Map<Integer,List<Student>>> d=studentList.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.groupingBy(
                        e1->{
                            // 返回值类型需要和处理判断的值一致
                            if(((Student)e1).getAge()>50){
                                return 1;
                            }if(((Student)e1).getAge()<30){
                                return 2;
                            }else {
                                return 3;
                            }
                        }
                )));
        System.out.println(d);
    }

    /**
     * @Description: 分段
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 9:22
     */
    @Test
    public void test5(){
        // 满足条件的一段不满足条件的一段
        Map<Boolean,List<Student>> d= studentList.stream().collect(Collectors.partitioningBy(e->e.getAge()>100));
        System.out.println(d);
    }

    /**
     * @Description: SummarizingInt
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 9:35
     */
    @Test
    public void test6(){
        IntSummaryStatistics d= studentList.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(d.getMax());
        System.out.println(d.getAverage());
        System.out.println(d.getMin());
    }

    /**
     * @Description: 字符串拼接操作
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/27 9:38
     */
    @Test
    public void test7(){
        String d=studentList.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new)).stream().collect(Collectors.joining(","));
        System.out.println(d);
    }

}
