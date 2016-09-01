package com.example.aop.cglib;

public class Proxy extends Hello{

	@Override
	public void say() {
		System.out.println("------------before Logic---------");
		
		super.say();

		System.out.println("------------after Logic----------");
		
	}
	

}
