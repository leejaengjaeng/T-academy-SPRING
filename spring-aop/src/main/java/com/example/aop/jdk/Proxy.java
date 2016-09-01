package com.example.aop.jdk;

public class Proxy implements Hello{

	private Hello target;
	
	public Proxy(Hello target) {
		this.target = target;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void say() {
		System.out.println("------------before Logic---------");
		
		target.say();

		System.out.println("------------after Logic----------");
		
	}
	

}
