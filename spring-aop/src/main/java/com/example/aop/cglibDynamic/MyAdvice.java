package com.example.aop.cglibDynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("------------before Logic---------");
		
		Object ret = invocation.proceed();
		
		System.out.println("------------after Logic----------");
	
		return ret;
	}

}
