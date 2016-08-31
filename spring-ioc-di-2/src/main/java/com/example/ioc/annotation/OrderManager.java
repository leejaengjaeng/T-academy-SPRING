package com.example.ioc.annotation;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("manager")
public class OrderManager {
	
//	@Autowired
//	@Resource(name="hyundai")
	private CarMaker maker;
	
	public OrderManager() {
		// TODO Auto-generated constructor stub
	}
	public OrderManager(CarMaker someMaker) 
	{
		this.maker = someMaker;
	}
	
	public void order()
	{
		Money money = new Money(1000);
		System.out.println("매니저가 차팔았음");
		Car car = this.maker.sell(money);
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("OrderManager.init();");
	}

	@Autowired
	@Qualifier("kiaMaker")
	//xml을 쓰려면 setter 필요 
	public void setMaker(CarMaker maker)
	{
		this.maker = maker;
	}
}
