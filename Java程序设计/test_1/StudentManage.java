package com.cyr;

/**
 * File Name:StudentManage
 * Package Name:com.cyr
 * Author:Mic_D
 * Description:学生管理系统实现功能，六个功能录入，查找，排序，修改，删除。调用s内的方法和s内的private中的数据
 */

import java.util.Scanner;

public class StudentManage {
    public static Student s = new Student();
    //主函数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            String input = sc.next();
            switch (input) {
                case "1":
//                    System.out.println("增加学生");
                    addStudent(s.getN());
                    s.setN(s.getN() + 1);   //现有人数加一 不可以++
                    //扩容
                    if(s.getN() >= s.getNumber()) {
                        //容量加3
                        s.setNumber(s.getNumber() + 3);
                    }
                    break;
                case "2":
//                    System.out.println("删除学生");
                    int num2 = checkStudent();
                    delStudent(num2);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    modifyStudent();
                    break;
                case "4":
//                    System.out.println("查找学生");
                    int num = checkStudent();
                    if(num != -1) {
                        System.out.println("学号\t\t" + "姓名\t\t" + "年龄\t" + "班级");
                        s.show(num);
                    }
                    break;
                case "5" :
//                    System.out.println("排序学生信息");
                    sortStudent();
                    break;
                case "6" :
                    System.out.println("学号\t\t" + "姓名\t\t" + "年龄\t" + "班级");
                    for(int i=0; i < s.getN();i++) {
                        s.show(i);
                    }
                    System.out.println("\t\t\t\t" + s.getN() + "/" + s.getNumber());
                    break;
                case "0":
                    System.out.println("退出成功\n谢谢使用");
                    System.exit(0);
                default:
                    System.out.println("输入有误,重新输入");
                    break;
            }
        }
    }

    //主菜单
    public static void menu() {
        System.out.println("--------输入数字选择功能--------");
        System.out.println("---1.增加学生信息---2.删除学生信息---");
        System.out.println("---3.修改学生信息---4.查找学生信息---");
        System.out.println("---5.排序学生信息---6.打印所有信息---");
        System.out.println("---------0.退出系统-----------");
    }

    //录入信息
    public static void addStudent(int index) {
        Scanner sc = new Scanner(System.in);
        String sid;
        //判重
        while (true) {
            int i;
            System.out.print("输入学号:>");
            sid = sc.next();
            for (i = 0; i < s.getN(); i++) {
                if (sid.equals(s.getSid()[i])) {
                    System.out.println("学号已有，请重新录入");
                    break;
                }
            }
            if (i >= s.getN()) {
                s.setSid(sid, index);
                break;
            }
        }
        System.out.print("输入姓名:>");
        String name = sc.next();
        s.setName(name, index);
        System.out.print("输入年龄:>");
        String age = sc.next();
        s.setAge(age, index);
        System.out.print("输入班级:>");
        String room = sc.next();
        s.setRoom(room, index);
        System.out.println("录入成功");
    }

    //子菜单
    public static void menu2() {
        System.out.println("-----选择查找方式-----");
        System.out.println("----1.按学号查找----");
        System.out.println("----2.按姓名查找----");
        System.out.print("请输入数据:>");
    }

    //查找学生
    public static int checkStudent() {
        Scanner sc = new Scanner(System.in);
        int i;
        if(s.getN() == 0) {
            System.out.println("系统无数据");
            return -1;
        } else {
            menu2();
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.print("输入要查找的学号:>");
                String sid = sc.next();
                for (i = 0; i < s.getN(); i++) {
                    if (sid.equals(s.getSid()[i]))
                        return i;
                }
                if (i >= s.getN()) {
                    System.out.println("查无此人");
                    return -1;
                }
            } else if (input.equals("2")) {
                System.out.print("输入要查找的姓名:>");
                String name = sc.next();
                    for (i = 0; i < s.getN(); i++) {
                        if (name.equals(s.getName()[i]))
                            return i;
                    }
                        if (i >= s.getN()) {
                            System.out.println("查无此人");
                                return -1;
                        }
            } else {
                System.out.println("输入错误");
                return -1;
            }
            return i;
        }
}

    //修改学生
    public static void modifyStudent() {
        int num = checkStudent();
        if(num != -1) {
            System.out.println("查找成功\n");
            System.out.println("学号\t\t" + "姓名\t" + "年龄\t" + "班级");
            s.show(num);
            addStudent(num);
            System.out.println("修改成功");
        }
    }

    //删除模块
    public static void delStudent(int num) {
        if(num != -1) {
            System.out.println("查找成功");
            s.show(num);
            //开始删除  后续元素往前移
            for(int i=0; i<s.getN() - num; i++) {
                s.setSid(s.getSid()[num + i + 1], num + i);
                s.setName(s.getName()[num + i + 1], num + i);
                s.setAge(s.getAge()[num + i + 1], num + i);
                s.setRoom(s.getRoom()[num + i + 1], num + i);
                s.setN(s.getN() - 1);
            }
            System.out.println("删除成功");
        }
    }

    //子菜单3
    public static void menu3() {
        System.out.println("------------------");
        System.out.println("-----1. 学号-------");
        System.out.println("-----2. 年龄-------");
        System.out.println("-----3. 班级-------");
        System.out.println("------------------");
    }
    //排序模块
    public static void sortStudent() {
        Scanner sc = new Scanner(System.in);
            menu3();
        String input = sc.next();
        switch(input) {
            case "1" :
                sonsort(s.getSid());
                break;
            case "2" :
                sonsort(s.getAge());
                break;
            case "3" :
                sonsort(s.getRoom());
                break;
            default:
                System.out.println("输入错误");
                break;
        }

    }

    //son sort
    public static void sonsort(String[] a) {
        boolean flag = true;
        for(int i = 0; i < s.getN(); i++) {
            for(int j = 0; j < s.getN() - i - 1; j++) {
                if(a[j].compareTo(a[j+1]) >= 0) {
                    String temp = s.getSid()[j+1];
                    s.getSid()[j+1] = s.getSid()[j];
                    s.getSid()[j] = temp;

                    temp = s.getName()[j+1];
                    s.getName()[j+1] = s.getName()[j];
                    s.getName()[j] = temp;

                    temp = s.getAge()[j+1];
                    s.getAge()[j+1] = s.getAge()[j];
                    s.getAge()[j] = temp;

                    temp = s.getRoom()[j+1];
                    s.getRoom()[j+1] = s.getRoom()[j];
                    s.getRoom()[j] = temp;
                    flag = false;
                }
            }
            //跑了一遍没换   说明有序直接结束
            if(flag)
                break;
        }
    }

}


