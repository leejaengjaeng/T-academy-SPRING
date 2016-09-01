package onj.hello.aspectJ;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Advise
public class Aspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("----around Before");
		Object ret = arg0.proceed();
		System.out.println("----around after");
		return ret;
	}
}
