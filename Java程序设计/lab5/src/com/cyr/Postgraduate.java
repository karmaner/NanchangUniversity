package com.cyr;

import java.util.Scanner;

/**
 * Package Name:com.cyr
 * File Name:Student
 * Author:Mic_D
 * Description:研究生类
 */

//研究生用继承
public class Postgraduate extends Student {

    private String teacher_name;
    private String research_direction;
    //研究生人数
    private static int num_postgrad;

    public Postgraduate() {
        num_postgrad++;
    }

    public Postgraduate(String sid, String name, String age, String room) {
        super(sid, name, age, room);
        num_postgrad++;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getResearch_direction() {
        return research_direction;
    }

    public void setResearch_direction(String research_direction) {
        this.research_direction = research_direction;
    }

    public static int getNum_postgrad() {
        return num_postgrad;
    }

    @Override
    public void deleteStudent() {
        super.deleteStudent();
        num_postgrad--;
    }

    public void init() {
        //基类数据初始化
        Scanner sc = new Scanner(System.in);
        System.out.print("input Student id:>");
        String sid = sc.next();
        super.setSid(sid);
        System.out.print("input name:>");
        String name = sc.next();
        super.setName(name);
        System.out.print("input age:>");
        String age = sc.next();
        super.setAge(age);
        System.out.print("input class:>");
        String room = sc.next();
        super.setRoom(room);
        System.out.print("input address:>");
        String address = sc.next();
        super.setAddress(address);

        //派生类数据初始化
        System.out.print("input postgraduate's teacher's name:>");
        name = sc.next();
        this.setTeacher_name(name);
        System.out.print("input postgraduate's research's direction:>");
        String research = sc.next();
        this.setResearch_direction(research);
    }
}
