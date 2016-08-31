package com.example.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class startPoint {

	public static void main(String[] args)
	{
		ApplicationContext context = new  ClassPathXmlApplicationContext("car-config-annotation.xml");

		OrderManager manager = context.getBean("manager", OrderManager.class);
		
		manager.order();
	}
}

