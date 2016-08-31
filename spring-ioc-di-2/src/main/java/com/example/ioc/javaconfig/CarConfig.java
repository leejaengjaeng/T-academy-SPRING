package com.example.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

	/*
	 * <bean id="makerK" class="com.example.ioc.xml.KiaMaker"/> 
	 * <bean id="makerH" class="com.example.ioc.xml.HyundaiMaker"/>
	 * 
	 * <bean id="manager" class="com.example.ioc.xml.OrderManager" init-method="init"> 
	 * <!-- setMaker를 사용해서 주입 --> 
	 * <!-- <property name="maker" ref="makerH"/> --> 
	 * <!-- 생성자에 넣기--> 
	 * <!-- constructor-arg 없으면 기본생성자로 만듦 --> 
	 * <constructor-arg ref="makerH"/> 
	 * </bean>
	 */
	
	@Bean(name="makerK")
	public CarMaker kia()
	{
		CarMaker maker = new KiaMaker();
		return maker;
	}
	@Bean(name="makerH")
	public CarMaker hyundai()
	{
		CarMaker maker = new HyundaiMaker();
		return maker;
	}
	@Bean(name="manager")
	public OrderManager manager()
	{
		OrderManager manager = new OrderManager(hyundai());
		return manager;
	}

}
