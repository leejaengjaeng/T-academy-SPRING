package com.example.ioc.javaconfig;
import org.springframework.stereotype.Service;

//<bean id="hyundai" class="com.example.ioc.xml.HyundaiMaker"/> 이거랑 동일 하다고 생각하면됨
@Service("hyundai")
public class HyundaiMaker implements CarMaker {
	
	public HyundaiMaker() 
	{
		// TODO Auto-generated constructor stub
	}

	public Car sell(Money money) 
	{
		Car car = new Car("sonata");
		System.out.println("현대차 팜 ");

		return car;
	}
}
