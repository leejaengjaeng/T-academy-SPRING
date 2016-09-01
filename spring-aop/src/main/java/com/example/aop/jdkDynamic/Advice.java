package com.example.aop.jdkDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Advice implements InvocationHandler{

	private Object target;
	
	public Advice(Object target)
	{
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("------------before Logic---------");
		
		Object ret = method.invoke(target, args);
		
		System.out.println("------------after Logic----------");
		
		return ret;
	}

}
