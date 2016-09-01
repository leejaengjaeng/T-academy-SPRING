package onj.hello.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggingAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		String findName = (String)arg1[0];
		System.out.println(arg0.getName() + "("+findName+"):: 사전충고");
	}

}
