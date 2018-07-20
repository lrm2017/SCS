package com.example.scs.database;

import com.example.scs.database.Student;



import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 夏目斑熊 on 2018/7/18.
 */

public class Course extends LitePalSupport {
    private int id;//课程号
    private String course_name;//课程名字
    private String teacher;//老师名字
    private int course_coad;//课程学分
    private String time;//任课时间
    private List<Student> courseList=new ArrayList<Student>();//一个课对应多个学生

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public int getCourse_coad() {
        return course_coad;
    }

    public void setCourse_coad(int course_coad) {
        this.course_coad = course_coad;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Student> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Student> courseList) {
        this.courseList = courseList;
    }
}
