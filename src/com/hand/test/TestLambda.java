package com.hand.test;

import com.hand.lamba.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhongLingYun
 * @Title: TestLambd
 * @Description: TODO
 * @date 2018/9/1811:25
 */
public class TestLambda {
    // 对数据排序
   static List<Student> students= Arrays.asList(
           /* new Student("张三",10,10),
            new Student("李四",10,39),
            new Student("王五",45,103),
            new Student("刘四",45,100),
            new Student("张飞",104,2),
            new Student("诸葛亮",48,10000),
            new Student("曹操",48,400),
            new Student("路人甲",2,45)*/
    );

    public static void main(String[] args) {
    test1();
}

    /**
     * @Description: TODO
     * @param: 按照年龄和名字排序
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/18 14:55
     */
    public static void test1(){
        Collections.sort(students,(e1,e2)->{
            // 如果年龄相等就按照姓名排序
            if(Objects.equals(e1.getAge(), e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else{
                // 升序
                //return Integer.compare(e1.getAge(),e2.getAge());
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        students.forEach(System.out::println);


    }

/**
 * @Description: 对字符串进行操作
 * @param:
 * @return:
 * @auther: ZhongLingYun
 * @date: 2018/9/18 15:15
 */
    public String stringFunction(String str,Lambda lambda){
        return lambda.getValue(str);
    }

    /**
     * @Description: 裁剪字符串
     * @param:
     * @return:
     * @auther: ZhongLingYun
     * @date: 2018/9/18 15:17
     */
@Test// 单元测试Junit需要版本是4.10
    public void str1(){
    //去除空格
        // String str1=stringFunction("     123456   ",str -> str.trim());
        // System.out.println(str1);

    //小写变大写
    String str2=stringFunction("abcdfef",str -> str.toUpperCase());
    // System.out.println(str2);

    // 裁剪2-4
    String str3=stringFunction("1234567890",str -> str.substring(2,4));
    System.out.print(str3);
    }

    //long数据操作
    public  void aboutLong(Long l1,Long l2,MyFunction<Long,Long> myFunction){// 此处需要指定数据类型
        System.out.println(myFunction.getValue(l1,l2));
    }

    @Test
    public void testeeee3(){
        aboutLong(1000L,234L,(y,x)-> x+y);
        aboutLong(1233L,45678L,(x,y)->x*y);

    }



}
