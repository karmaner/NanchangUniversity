package com.cyr.service.impl;

/**
 * Package Name:com.cyr.PersonService.impl
 * File Name:PersonServiceImpl
 * Author:Mic_D
 * Description:PersonService 实现类
 * 				这个类基本都不需要怎么修改 仅仅只是调用dao层已经写好了的方法
 * 				除了排序功能是特殊的
 */

import java.util.Collections;
import java.util.List;
import com.cyr.dao.PersonDao;
import com.cyr.dao.impl.PersonDaoImpl;
import com.cyr.dao.impl.ToComparator;
import com.cyr.model.Person;
import com.cyr.service.PersonService;

public class PersonServiceImpl implements PersonService{

	//接口回调调用方法
	private PersonDao personDao = new PersonDaoImpl();
	@Override
	public int savaPerson(Person person) {
		//实现自动保存上一个职员
		personDao.savaFile();
		return personDao.savaPerson(person);
	}

	@Override
	public int deletePerson(String name) {
		// TODO Auto-generated method stub
		//实现自动读取文件中的数据
		personDao.readFile();
		return personDao.deletePerson(name);
	}

	@Override
	public Person getPerson(String name) {
		// TODO Auto-generated method stub
		//实现自动读取文件中的数据
		personDao.readFile();
		return personDao.getPerson(name);
	}

	@Override
	public int updataPerson(String name) {
		// TODO Auto-generated method stub
		//实现自动读取文件中的数据
		personDao.readFile();
		return personDao.updataPerson(name);
	}

	@Override
	public List<Person> listPerson() {
		// TODO Auto-generated method stub
		//实现自动读取文件中的数据
		personDao.readFile();
		return personDao.listPerson();
	}

	@Override
	public void savaFile() {
		// TODO Auto-generated method stub
		personDao.savaFile();
		return;
	}

	@Override
	public void readFile() {
		// TODO Auto-generated method stub
		personDao.readFile();
		return;
	}
	@Override
	public void sortPerson() {
		//创建排序对象进行排序
		ToComparator T = new ToComparator();
		//官方排序方法
		Collections.sort(personDao.getList(), T);
	}
	
	
}
