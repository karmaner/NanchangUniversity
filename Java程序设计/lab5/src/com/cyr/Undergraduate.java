package com.cyr;

import java.util.Scanner;

/**
 * Package Name:com.cyr
 * File Name:Student
 * Author:Mic_D
 * Description:本科生类
 */

//本科生用组合
public class Undergraduate{
    //组合实现
    private Student s = new Student();

    private String major;
    private static int num_Undergrad;

    public Undergraduate() {
        Student.setNum(Student.getNum() + 1);
        num_Undergrad++;
    }
    public Undergraduate(String major) {
        this.major = major;
        Student.setNum(Student.getNum() + 1);
        num_Undergrad++;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static int getNum_Undergrad() {
        return num_Undergrad;
    }

    public void deleteStudent() {
        s.deleteStudent();
        num_Undergrad--;
    }

    public Student getS() {
        return s;
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input Student id:>");
        String sid = sc.next();
        this.getS().setSid(sid);
        System.out.print("input name:>");
        String name = sc.next();
        this.getS().setName(name);
        System.out.print("input age:>");
        String age = sc.next();
        this.getS().setAge(age);
        System.out.print("input class:>");
        String room = sc.next();
        this.getS().setRoom(room);
        System.out.print("input address:>");
        String address = sc.next();
        this.getS().setAddress(address);

        //派生类数据初始化
        System.out.print("input Undergrad's major:>");
        String major = sc.next();
        this.setMajor(major);
    }
}
