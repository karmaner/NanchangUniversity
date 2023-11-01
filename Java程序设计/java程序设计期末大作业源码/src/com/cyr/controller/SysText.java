package com.cyr.controller;


/**
 * Package Name:com.cyr.controller
 * File Name:SysText
 * Author:Mic_D
 * Description:系统测试类
 */

import java.util.Scanner;
import com.cyr.model.Person;
import com.cyr.model.Position;
import com.cyr.model.TempWorks;
import com.cyr.service.PersonService;
import com.cyr.service.impl.PersonServiceImpl;
import com.cyr.view.MyFrame;

public class SysText {
	// 接口回调采用方法 static方便其他方法调用
	static PersonService personService = new PersonServiceImpl();

	//主函数
	public static void main(String[] args) {
		
		//登录界面
		new MyFrame();
		
		//防止崩溃eclipse提示
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				menu();
				System.out.print("请输入数字选择功能:>");
				String input = sc.next();
				switch (input) {
				case "1":
					addPerson();
					break;
				case "2":
					deletePerson();
					//或者deletePeson(name);
					break;
				case "3":
					findPerson();
					//或者findPerson(name);
					break;
				case "4":
					//修改职员
					updataPerson();
					break;
				case "5":
					//遍历职员
					listPerson();
					break;
				case "6":
					//排序成员
					sortPerson();
					break;
				case "7":
					//保存文件
					savaFile();
					break;
				case "8":
					//读取文件
					readFile();
					break;
				case "9":
					//关于
					about();
					break;
				case "0":
					System.out.println("退出成功");
					System.exit(0);
					break;

				default:
					break;
				}
			}
		}

	} 

	// 主菜单，显示菜单功能
	public static void menu() {
		System.out.println("----------------------");
		System.out.println("1-----添加/读取职员------");
		System.out.println("2-------删除职员--------");
		System.out.println("3-------查询职员---------");
		System.out.println("4-------修改职员---------");
		System.out.println("5-----查看所以职员--------");
		System.out.println("6-------排序职员--------");
		System.out.println("7-------保存文件--------");
		System.out.println("8-------读取文件--------");
		System.out.println("9--------关于---------");
		System.out.println("0-------退出系统--------");
		System.out.println("----------------------");
	}

	// 添加职员功能
	public static void addPerson() {
		try (Scanner sc = new Scanner(System.in)) {
			// 添加对象初始化
			System.out.println("1.添加正式员工" + "\n" + "2.添加临时员工");
			System.out.println("请输入添加员工类型");
			String input = sc.next();
			if (input.equals("1")) {
				String name, position, ssex;
				int age, salary;
				boolean sex;

				System.out.print("输入姓名:>");
				name = sc.next();
				System.out.print("输入年龄:>");
				age = sc.nextInt();
				System.out.print("输入性别:>");
				ssex = sc.next();
				sex = booleanMorF(ssex);
				System.out.print("输入职位:>");
				position = sc.next();
				System.out.print("输入月工资:>");
				salary = sc.nextInt();
				// 多态建立对象 子类特殊数据也要保存
				Person person = new Position(name, age, sex, position, salary);
				// 保存对象	本层用sercice方法⬇
				//			sercice层调用⬇
				//			dao层数据操作
				personService.savaPerson(person);
			} else if (input.equals("2")) {
				String name, ssex;
				int age, daysalary;
				boolean sex;

				System.out.print("输入姓名:>");
				name = sc.next();
				System.out.print("输入年龄:>");
				age = sc.nextInt();
				System.out.print("输入性别:>");
				ssex = sc.next();
				sex = booleanMorF(ssex);
				System.out.print("输入日工资:>");
				daysalary = sc.nextInt();
				// 多态建立对象 子类特殊数据也要保存
				Person person = new TempWorks(name, age, sex, daysalary);
				// 保存对象
				personService.savaPerson(person);
			} else {
				System.out.println("输入错误");
			}
		}

	}

	// 性别判断函数
	public static boolean booleanMorF(String ssex) {
		if (ssex.equals("男")) {
			return false;
		} else if (ssex.equals("女")) {
			return true;
		} else {
			System.out.println("输入错误" + "," + "默认为女");
			return true;
		}
	}

	//删除职工
	public static void deletePerson() {
		try(Scanner sc = new Scanner(System.in) ) {
			System.out.print("输入要删除职工姓名:>");	
			String name = sc.next();
			personService.deletePerson(name);
		}
		
	}
	//重载删除员工
	public static void deletePerson(String name) {
		personService.deletePerson(name);
	}

	//查找员工
	public static void findPerson() {
		try(Scanner sc = new Scanner(System.in) ) {
			System.out.print("输入要查找职工姓名:>");	
			String name = sc.next();
			System.out.println(personService.getPerson(name));
		}
	}
	//查找重载
	public static void findPerson(String naem) {
		System.out.println(personService.getPerson(naem));
	}
	
	//修改职员
	public static void updataPerson() {
		try(Scanner sc = new Scanner(System.in) ) {
			System.out.print("输入要删除职工姓名:>");	
			String name = sc.next();
			personService.updataPerson(name);
		}
	}
	
	//遍历职员
	public static void listPerson() {
		personService.listPerson();
	}
	
	//排序职员
	public static void sortPerson() {
		personService.sortPerson();
	}
	
	//保存文件
	public static void savaFile() {
		personService.savaFile();
	}
	
	//读取文件
	public static void readFile() {
		personService.readFile();
	}
	
	//关于
	public static void about() {
		System.out.println("\t\t人事管理系统 bate 2.2" + "\n" 
										+ "\t作者：2021届 软件学院 陈映融\n"
										+ "\t班级：2103版\n"
										+ "\t学号：8008121077"
										+ "\t功能简介：有增删改查排的功能，"
										+ "有自动保存文件和开始前读取文件的功能"
										+ "\t其中有登录界面采用gui设计");
	}
	
	
	
}
