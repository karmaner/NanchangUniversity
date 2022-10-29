package com.cyr;

import javax.swing.*;

/**
 * Package Name:com.cyr
 * File Name:Student
 * Author:Mic_D
 * Description:学生类
 */

public class Student {
    private String sid;
    private String name;
    private String age;
    private String room;
    private String address;
    //静态变量记录学生人数
    private static int num;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //构造方法
    public Student() {
        num++;
    }

    public Student(String sid, String name, String age, String room) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.room = room;
        num++;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Student.num = num;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void deleteStudent() {
        System.out.println("学生删除成功");
        num--;
    }

}
