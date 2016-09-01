package com.example.aop.jdkDynamic;

import java.lang.reflect.Proxy;

public class TestMain {

	public static void main(String[] args)
	{
		Hello hello = new HelloImpl();
		
		//Proxy.java를 삭제
		//Hello proxy = new Proxy(hello);
		//proxy.say();
		
		//JDK Dynamic Proxy
		Hello proxy = (Hello) Proxy.newProxyInstance(
				Hello.class.getClassLoader(),
				hello.getClass().getInterfaces(),
				new Advice(hello));
		proxy.say();
	}
}
