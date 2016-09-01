package com.example.aop.cglib;

public class TestMain {

	public static void main(String[] args)
	{
		Hello hello = new Hello();
		hello.say();
		
		Hello proxy = new Proxy();
		proxy.say();
		
		/*
		System.out.println("------------before Logic---------");
		hello.say();
		System.out.println("------------after Logic----------");
		*/
		
		
	}
}
