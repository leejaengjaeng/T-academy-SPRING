package onj.hello.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		String findName = (String)arg0.getArguments()[0];
		String methodName = (String)arg0.getMethod().getName();
		System.out.println("주변충고 "+methodName+","+findName+" 실행전");
		Object obg = arg0.proceed();
		System.out.println("주변충고 "+methodName+","+findName+" 실행전");
		
		return obg ;
	}
	

}
