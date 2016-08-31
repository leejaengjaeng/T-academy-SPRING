package com.example.ioc.annotation;
import org.springframework.stereotype.Service;

//Service에 id를 지정하지 않으면 클래스이름으로 지정됨 
//id는 소문자로 시작됨으로 kiaMaker가 id로 설정됨 
@Service
public class KiaMaker implements CarMaker {
	
	public KiaMaker() 
	{
		// TODO Auto-generated constructor stub
	}

	public Car sell(Money money) 
	{
		Car car = new Car("K5");
		System.out.println("기아차 팜 ");

		return car;
	}
}
