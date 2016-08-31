package com.example.ioc.xml;

import org.springframework.stereotype.Component;

public class OrderManager {
	
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
		System.out.println("차팔았음");
		Car car = this.maker.sell(money);
	}
	
	public void init()
	{
		System.out.println("OrderManager.init();");
	}
/*	
	//xml을 쓰려면 setter 필요 
	public void setMaker(CarMaker maker)
	{
		this.maker = maker;
	}
*/
}
