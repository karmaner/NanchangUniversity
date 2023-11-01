package com.cyr.model;

/**
 * Package Name:com.cyr.model
 * File Name:Position
 * Author:Mic_D
 * Description:正式工类
 */

public class Position extends Person{
	//写的目的是增加程序的通用性  不用编译器给
	private static final long serialVersionUID = -316102412618444933L;
	private String position;
	private int salary;
	//分别正式工和临时工 id由系统给出
	private String id;
	private static int num;
	public Position() {
		super();
		num++;
		//构造方法时给出id
		this.id = "A" + num;
	}
	public Position(String name, int age, boolean sex, String position, int salary) {
		super(name, age, sex);
		this.position = position;
		this.salary = salary;
		num++;
		//构造方法时给出id
		this.id = "A" + num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//方便打印
	@Override
	public String toString() {
		return "Position [position=" + position + ", salary=" + salary + ", id=" + id + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", isSex()=" + isSex() + "]";
	}

	
	
}
