package com.cyr.dao.impl;

/**
 * Package Name:com.cyr.dao.impl
 * File Name:PersonDaoImpl
 * Author:Mic_D
 * Description:  PersonDao接口实现类 实现PersonDao接口中的内容
 * 					基本内容的增上改查排实现
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cyr.dao.PersonDao;
import com.cyr.model.Person;

//DAO层实现类
public class PersonDaoImpl implements PersonDao {

	//集合存储数据 在写入文件中 private实现封装保护数据
	private static List<Person> list = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);
	@Override
	public int savaPerson(Person person) {
		if(list.add(person)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int deletePerson(String name) {
		Person team = null;
		if((team = findStuentbyName(name)) != null) {
			list.remove(team);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Person getPerson(String name) {
		Person team = findStuentbyName(name);
		return team;
	}

	@Override
	public int updataPerson(String name) {
		Person team = null;
		if((team = findStuentbyName(name)) != null) {
			System.out.println("输入性别");
			if(sc.next().equals("女")) {
				team.setSex(true);				
			} else if(sc.next().equals("男")) {
				team.setSex(false);
			}
			System.out.println("输入年龄");
			team.setAge(sc.nextInt());
			return 1;
		} else {
			return 0;
		}
		
	}

	@Override
	public List<Person> listPerson() {
		for(Person team : list) {
			System.out.println(team);
		}
		return list;
	}
	
	//查找学生  多次调用
	public static Person findStuentbyName(String name) {
		Person person = null;
		for(Person p : list) {
			if(p.getName().equals(name)) {
				person = p;
			}
		}
		return person;
	}
	
	public static Person findStuentbyName(int age) {
		Person person = null;
		for(Person p : list) {
			if(p.getAge() == age) {
				person = p;
			}
		}
		return person;
	}
	
	//输入输出流保存文件
	@Override
	public void savaFile() {
		//异常判断如果没用文件
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("Person.dat"));
			out.writeObject(list);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void readFile() {
		//异常判断如果没用文件
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("Person.dat"));
			@SuppressWarnings("unchecked")
			List<Person> nList = (List<Person>)in.readObject();
			in.close();
			PersonDaoImpl.list = nList; 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Person> getList() {
		return list;
	}
	
}

