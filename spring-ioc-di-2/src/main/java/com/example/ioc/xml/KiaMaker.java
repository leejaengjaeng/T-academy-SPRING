package com.example.ioc.xml;


public class KiaMaker implements CarMaker {
	
	public KiaMaker() 
	{
		// TODO Auto-generated constructor stub
	}

	public Car sell(Money money) 
	{
		System.out.println("I sold a car.");
		Car car = new Car("sonata");
		System.out.println("차 팜 ");

		return car;
	}
}
