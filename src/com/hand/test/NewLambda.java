package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ZhongLingYun
 * @Title: NewLambda
 * @Description: lambda表达式的方法引用
 * @date 2018/9/1917:29
 */
public class NewLambda {
    // 使用过程中需要参数和返回值类型必须保持一致

    @Test
    public void test(){
        // 林外一边被实际的方法所替代，可以直接：：
        Consumer<String> consumer=System.out::print;
        consumer.accept("你好");
    }

    @Test
    public void test1(){
        Student student = new Student();
        Supplier<String> supplier=student::getName;
        System.out.println(supplier);


        Supplier<Integer> dd= student::getAge;
        System.out.print(dd);
    }

    @Test
    public void test2(){
        Comparator<Integer> comparable=Integer::compare;
        System.out.print(comparable.compare(1000,300));
    }

    @Test
    public void test3(){
        BiPredicate<String,String> biPredicate=String::equals;
        System.out.println(biPredicate.test("ertyu","ertyui"));
    }

    @Test
    public void test4(){
        //
        Supplier<Student> studentSupplier=Student::new;
        System.out.print(studentSupplier.get().getName());


        Function<Integer,Student> function=(x)->new Student();
        System.out.println(function.apply(10));
    }
}
