package com.hand.lamba;

/**
 * @author ZhongLingYun
 * @Title: Student
 * @Description: TODO
 * @date 2018/9/1718:08
 */
public class Student {
    private String name;
    private Integer age;
    private Integer grade;
    public Student(String name, Integer age, Integer grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
