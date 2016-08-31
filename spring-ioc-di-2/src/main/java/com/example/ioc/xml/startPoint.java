package com.example.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class startPoint {

	public static void main(String[] args)
	{
		//WAS 실행시 완료?
		ApplicationContext context = new  ClassPathXmlApplicationContext("car-config.xml");
		//@Autowired,@Resource,@Inject등을 코드로 쓴거 
		// 스프링은 기본적으로 객체를 singleton으로 관리 
		OrderManager manager = context.getBean("manager", OrderManager.class);
		manager.order();
	}
}

