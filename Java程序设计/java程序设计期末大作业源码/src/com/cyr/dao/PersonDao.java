package com.cyr.dao;

/**
 * Package Name:com.cyr.dao
 * File Name:PersonDao
 * Author:Mic_D
 * Description:PersonDao接口  用于功能显示和接口回调方便调用
 */

import java.util.List;

import com.cyr.model.Person;

public interface PersonDao {
	
		public int savaPerson(Person person);
		public int deletePerson(String name);
		public Person getPerson(String name);
		public int updataPerson(String name);
		public List<Person> listPerson();
		public void savaFile();
		public void readFile();
		public List<Person> getList();
}
