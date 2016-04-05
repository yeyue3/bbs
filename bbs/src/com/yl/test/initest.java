package com.yl.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yl.domain.Category;
import com.yl.service.imp.BaseService;

public class initest {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println(ac.getBean("sessionFactory"));
		BaseService bs = new BaseService();
		List<Category> list = bs.queryAllCate();
		System.out.println(list.get(0));
	}

}
