package com.cyr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Demo {
    //创建集合来储存学生
    static ArrayList<Postgraduate> array1 = new ArrayList<>();     //研究生
    static ArrayList<Undergraduate> array2 = new ArrayList<>();    //本科生

    //主函数功能
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu();
        while (true) {
            System.out.print("输入数字选择功能:>");
            String input = sc.next();
            switch (input) {
                case "1":
                    addStudent();
                    System.out.println("可以添加\n添加成功");
                    break;
                case "2":
                    deleteStudent();
                    break;
                case "3":
                    modefilyStudent();
                    break;
                case "4":
                    if (Student.getNum() > 0) {
                        System.out.print("输入学生学号:>");
                        String sid = sc.next();
                        checkStudent(sid);
                    } else {
                        System.out.println("No man");
                    }
                    break;
                case "5":
                    sortStudent();
                    break;
                case "6":
                    printStdent();
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

    //菜单
    public static void menu() {

        System.out.println("-----------------------------");
        System.out.println("*       输入数字选择功能       *");
        System.out.println("*       1.增加学生信息        *");
        System.out.println("*       2.删除学生信息        *");
        System.out.println("*       3.修改学生信息        *");
        System.out.println("*       4.查找学生信息        *");
        System.out.println("*       5.排序学生信息        *");
        System.out.println("*       6.打印所有信息        *");
        System.out.println("*         0.退出系统         *");
        System.out.println("-----------------------------");

    }

    //查找学生信息
    public static int checkStudent(String sid) {
        if (Student.getNum() == 0) {
            System.out.println("No man");
            return Student.getNum() + 1;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (sid.equals(array1.get(i).getSid())) {
                System.out.println("研究生" + (i + 1));
                System.out.println("姓名：" + array1.get(i).getName());
                System.out.println("年龄：" + array1.get(i).getAge());
                System.out.println("学号：" + array1.get(i).getSid());
                System.out.println("专业：" + array1.get(i).getResearch_direction());
                System.out.println("班级：" + array1.get(i).getRoom());
                System.out.println("地址：" + array1.get(i).getAddress());
                System.out.println("导师：" + array1.get(i).getTeacher_name());
                return i;
            }
        }
        for (int i = 0; i < array2.size(); i++) {
            if (sid.equals(array2.get(i).getS().getSid())) {
                System.out.println("本科生" + (i + 1));
                System.out.println("姓名：" + array2.get(i).getS().getName());
                System.out.println("年龄：" + array2.get(i).getS().getAge());
                System.out.println("学号：" + array2.get(i).getS().getSid());
                System.out.println("专业：" + array2.get(i).getMajor());
                System.out.println("班级：" + array2.get(i).getS().getRoom());
                System.out.println("地址：" + array2.get(i).getS().getAddress());
                return -i;
            }
        }
        System.out.println("无此学号");
        return Student.getNum()+1;
    }

    //添加学生信息
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("添加学生本科生/研究生-0/1:>");
        String choose = sc.nextLine();
        if (choose.equals("1")) {
            Postgraduate p1 = new Postgraduate();
            p1.init();
            int flag = checkStudent(p1.getSid());
            if (flag > Student.getNum()) {
                array1.add(p1);
            } else {
                System.out.println("学号重复");
                p1.deleteStudent();
            }
        } else if (choose.equals("0")) {
            Undergraduate u1 = new Undergraduate();
            u1.init();
            int flag = checkStudent(u1.getS().getSid());
            if (flag > Student.getNum()) {
                array2.add(u1);
            } else {
                System.out.println("学号重复");
                u1.deleteStudent();
            }
        } else {
            System.out.println("输入错误");
        }

    }

    //删除学生信息
    public static void deleteStudent() {
        if(Student.getNum() == 0) {
            System.out.println("No man");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("input student's id:>");
        String sid = sc.next();
        int index = checkStudent(sid);
        if(index < 0) {
            array2.get(-index).deleteStudent();
            array2.remove(-index);
            System.out.println("删除成功");
        }
        if(index > 0 & index < Student.getNum()) {
            array1.get(index).deleteStudent();
            array1.remove(index);
            System.out.println("删除成功");

        }
    }

    //排序学生信息
    public static void sortStudent() {
        if(Student.getNum() == 0) {
            System.out.println("No man");
            return;
        }
        Collections.sort(array1, new Comparator<Postgraduate>() {
            @Override
            public int compare(Postgraduate o1, Postgraduate o2) {
                //按照年龄排序    这个是升序，降序就o2 和 o1换一个位置
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        Collections.sort(array2, new Comparator<Undergraduate>() {
            @Override
            public int compare(Undergraduate o1, Undergraduate o2) {
                return o1.getS().getAge().compareTo(o2.getS().getAge());
            }
        });

    }

    //打印学生信息
    public static void printStdent() {
        if(Student.getNum() == 0) {
            System.out.println("No man");
            return;
        }
        System.out.println("打印研究生");
        for(int i=0; i < Postgraduate.getNum_postgrad(); i++) {
            System.out.println("研究生" + (i + 1));
            System.out.println("姓名：" + array1.get(i).getName());
            System.out.println("年龄：" + array1.get(i).getAge());
            System.out.println("学号：" + array1.get(i).getSid());
            System.out.println("班级：" + array1.get(i).getRoom());
            System.out.println("地址：" + array1.get(i).getAddress());
            System.out.println("导师：" + array1.get(i).getTeacher_name());
            System.out.println("研究方向：" + array1.get(i).getResearch_direction());
        }

        System.out.println("打印本科生");
        for(int i=0; i < Undergraduate.getNum_Undergrad(); i++) {
            System.out.println("本科生" + (i + 1));
            System.out.println("姓名：" + array2.get(i).getS().getName());
            System.out.println("年龄：" + array2.get(i).getS().getAge());
            System.out.println("学号：" + array2.get(i).getS().getSid());
            System.out.println("班级：" + array2.get(i).getS().getRoom());
            System.out.println("地址：" + array2.get(i).getS().getAddress());
            System.out.println("专业：" + array2.get(i).getMajor());
        }
        System.out.println("研究生" + Postgraduate.getNum_postgrad() +"," + "本科生" + Undergraduate.getNum_Undergrad() + "," + "总人数" + Student.getNum());

    }

    //修改学生信息
    public static void modefilyStudent() {
        if(Student.getNum() == 0) {
            System.out.println("No man");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("input student's id:>");
        String sid = sc.next();
        int index = checkStudent(sid);
        if(index < 0) {
            Postgraduate p1 = new Postgraduate();
            p1.init();
            array1.add(-index, p1);
            System.out.println("修改成功");
        } else if(index > 0 & index < Student.getNum()) {
            Undergraduate u1 = new Undergraduate();
            u1.init();
            array2.add(index, u1);
            System.out.println("修改成功");

        } else {
            System.out.println("查无此人");
        }
    }

}
