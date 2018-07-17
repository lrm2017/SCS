package com.example.scs;

/**
 * Created by 夏目斑熊 on 2018/7/16.
 */

public class Student
{
    //每一个字段对应的表中的每一列，
    //Student类就对应着数据库中的student表
    private int id;
    private String student_number="未填写学号";
    private String name="未填写名字";
    private String password;
    private int age=0;
    private String class_number="未填写班级";
    private String college_name="未填写学院";
    private String text="请说出你的座右铭";


    ///////////id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    ///////////学号
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        if(student_number==null)
            this.student_number="未填写学号";
        else
            this.student_number = student_number;
    }

    ///////////姓名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null)
            this.student_number="未填写姓名";
        else
            this.name = name;
    }

    ////////////年龄
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    ////////////班级
    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        if(class_number==null)
            this.student_number="未填写班级";
        else
        this.class_number = class_number;
    }

    //////////学院
    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        if(college_name==null)
            this.student_number="未填写学院";
        else
        this.college_name = college_name;
    }

    ///////////座右铭
    public String getText() {
    return text;
}

    public void setText(String text) {
        if(text==null)
            this.student_number="请说出你的座右铭";
        else
            this.text = text;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

}