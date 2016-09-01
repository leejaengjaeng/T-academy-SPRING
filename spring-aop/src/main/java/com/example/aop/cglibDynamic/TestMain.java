package com.example.aop.cglibDynamic;

import org.springframework.aop.framework.ProxyFactory;

public class TestMain {

	public static void main(String[] args)
	{
		Hello hello = new Hello();
		hello.say();
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		factory.addAdvice(new MyAdvice());
		
		Hello proxy = (Hello)factory.getProxy();
		proxy.say();
		
		
	}
}
