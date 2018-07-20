package com.example.scs;

import org.litepal.crud.LitePalSupport;

/**
 * Created by 夏目斑熊 on 2018/7/18.
 */

public class Student_Course extends LitePalSupport {
    private int id;//课程序号
    private String courseId;
    private String course_name;//课程名
    private String teacher;//老师名
    private String time;//任课时间
    private String course_grade;//课程分数
    private String course_coad;//课程学分
    private Student student;//一对一，一个学生课程对应一个学生
    private int ImageId;

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

   /* public Student_Course(String course_name, String teacher, String course_grade, String course_coad, String time){
        this.course_name=course_name;
        this.teacher=teacher;
        this.course_grade=course_grade;
        this.course_coad=course_coad;
        this.time=time;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /* public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }*/

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourse_grade() {
        return course_grade;
    }

    public void setCourse_grade(String course_grade) {
        this.course_grade = course_grade;
    }

    public String getCourse_coad() {
        return course_coad;
    }

    public void setCourse_coad(String course_coad) {
        this.course_coad = course_coad;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
