package com.example.scs;



import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 夏目斑熊 on 2018/7/16.
 */

public class Student {
    //每一个字段对应的表中的每一列，
    //Student类就对应着数据库中的student表
    private int id;
    private String name="未填写名字";
    private String password;
    private int age=0;
    private String class_number="未填写班级";
    private String college_name="未填写学院";
    private String text="请说出你的座右铭";
    private List<Student_Course> courseList=new ArrayList<Student_Course>();//一个学生对应多个学生课程

    public List<Student_Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Student_Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student_Course> getCourse(){
        return DataSupport.where("news_id = ?", String.valueOf(id)).find(Student_Course.class);
    }

    ///////////学号
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    ////////////年龄
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
            this.class_number="未填写班级";
        else
        this.class_number = class_number;
    }

    //////////学院
    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        if(college_name==null)
            this.college_name="未填写学院";
        else
        this.college_name = college_name;
    }

    ///////////座右铭
    public String getText() {
    return text;
}

    public void setText(String text) {
        if(text==null)
            this.text="请说出你的座右铭";
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