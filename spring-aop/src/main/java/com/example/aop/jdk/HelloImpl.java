package com.example.aop.jdk;

public class HelloImpl implements Hello{

	@Override
	public void say() {
		//System.out.println("------------before Logic---------");
		System.out.println("Hello World");
		//System.out.println("------------after Logic----------");
	}

}
