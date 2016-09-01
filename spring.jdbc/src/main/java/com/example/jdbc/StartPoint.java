package com.example.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartPoint {

	
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EmpDao dao = context.getBean("empdao",EmpDao.class);
		int count = dao.count();
		System.out.println(count);
		
		List<EmpVo> emps = dao.selectByLimit(0, count);
		for(EmpVo emp : emps)
			System.out.println(emp);
	}
}
