package com.cyr.dao.impl;

/**
 * Package Name:com.cyr.dao.impl
 * File Name:ToComparator
 * Author:Mic_D
 * Description:比较接口实现类，通过姓名和年龄实现排序
 */

import java.util.Comparator;
import java.util.Scanner;

import com.cyr.model.Person;

public class ToComparator implements Comparator<Person>{
	//封装保护好系统sc接口
	private Scanner sc = new Scanner(System.in);
	@Override
	public int compare(Person o1, Person o2) {
		 System.out.println("请输入数字选择排序功能");
	        System.out.println("---------------------------------");
	        System.out.println("      1.  sort by name           ");
	        System.out.println("      2.  sort by age            ");
	        System.out.println("---------------------------------");
	        String input;
	        input = sc.next();
	        switch (input) {
	            case "1":
	                return Integer.compare(o1.getName().compareTo(o2.getName()), 0);
	            case "2":
	                return o1.getAge() > o2.getAge() ? 1 : 0;
	            default:
	                System.out.println("选择错误");
	                return 0;
	        }
	}
}
