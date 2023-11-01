package com.cyr.model;

import java.io.Serializable;

/**
 * Package Name:com.cyr.model
 * File Name:Person
 * Author:Mic_D
 * Description:人类基础父类
 */

//父类实现序列化接口方便保存文件
public class Person implements Serializable{
	//写的目的是增加程序的通用性  不用编译器给
	private static final long serialVersionUID = -316102412618444933L;
	private String name;
	private int age;
	//定义性别 false 为男   true 为女
	private boolean sex;
	public Person() {

	}
	public Person(String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
}
