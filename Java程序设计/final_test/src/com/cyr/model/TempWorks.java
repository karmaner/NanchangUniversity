package com.cyr.model;
/**
 * Package Name:com.cyr.model
 * File Name:TempWorks
 * Author:Mic_D
 * Description:临时工类
 */

public class TempWorks extends Person{
	private static final long serialVersionUID = -316102412618444933L;
	private int daySalary;
	//分别正式工和临时工 id由系统给出
	private String id;
	private static int num;
	public TempWorks() {
		num++;
		this.id = "B" + num;
	}
	public TempWorks(String name, int age, boolean sex, int daysalary) {
		super(name, age, sex);
		this.daySalary = daysalary;
		num++;
		//构造方法时给出id
		this.id = "B" + num;
	}
	public int getDaySalary() {
		return daySalary;
	}
	public void setDaySalary(int daySalary) {
		this.daySalary = daySalary;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//涨工资
	public void updateSalary(int num) {
		this.daySalary += num;
	}
	
	//方便打印
	@Override
	public String toString() {
		return "TempWorks [daySalary=" + daySalary + ", id=" + id + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", isSex()=" + isSex() + "]";
	}

}
