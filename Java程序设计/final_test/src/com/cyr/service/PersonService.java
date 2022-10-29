package com.cyr.service;

/**
 * Package Name:com.cyr.service
 * File Name:PersonService
 * Author:Mic_D
 * Description:服务中间成实现接口
 */

import java.util.List;

import com.cyr.model.Person;

public interface PersonService {
	public int savaPerson(Person person);
	public int deletePerson(String name);
	public Person getPerson(String name);
	public int updataPerson(String name);
	public List<Person> listPerson();
	public void savaFile();
	public void readFile();
	//相比dao层多了一个sortPerson接口
	public void sortPerson();
}
