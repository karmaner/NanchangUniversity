package com.cyr;

/**
 * File Name:Student
 * Package Name:com.cyr
 * Author:Mic_D
 * Description:基本的一个学生管理系统完成增删改查的基本功能
 */

/*
    20个学生的学生类   等待后续扩容

 */
public class Student {
    private int number = 20;        //学生容量
    private String[] sid = new String[number];
    private String[] name = new String[number];
    private String[] age = new String[number];
    private String[] room = new String[number];
    private static int n = 0;              //当前人数

    public Student() {
    }

    public Student(String sid, String name, String age, String room, int n) {
        this.sid[n] = sid;
        this.name[n] = name;
        this.age[n] = age;
        this.room[n] = room;
        this.n = n;
    }

    public String[] getSid() {
        return sid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student(int number) {
        this.number = number;
    }

    public void setSid(String sid, int i) {
        this.sid[i] = sid;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String name, int i) {
        this.name[i] = name;
    }

    public String[] getAge() {
        return age;
    }

    public void setAge(String age, int i) {
        this.age[i] = age;
    }

    public String[] getRoom() {
        return room;
    }

    public void setRoom(String room, int i) {
        this.room[i] = room;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void show(int i) {
        System.out.println(getSid()[i] + "\t\t" + getName()[i] +"\t" + getAge()[i] + "\t" + getRoom()[i]);
    }
}