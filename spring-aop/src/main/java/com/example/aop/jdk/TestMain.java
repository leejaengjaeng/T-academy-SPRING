package com.example.aop.jdk;

public class TestMain {

	public static void main(String[] args)
	{
		Hello hello = new HelloImpl();
		
		/*
		System.out.println("------------before Logic---------");
		hello.say();
		System.out.println("------------after Logic----------");
		*/
		
		Hello proxy = new Proxy(hello);
		proxy.say();
		
	}
}
