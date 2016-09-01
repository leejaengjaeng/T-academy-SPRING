package onj.hello.aspectJ;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class TestMain {
	public static void main(String[] args)
	{
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression("execution(public   * one*(..))");
		
		Advisor advisor = new DefaultPointcutAdvisor(pc,new Aspect());
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new First());
		ProxyFactory pf2 = new ProxyFactory();
		pf2.setTarget(new second());
		
		First f = (First) pf.getProxy();
		f.one();
		f.two();
		f.oneTwo();
		f.add(1, 2);
		
		second s = (second) pf2.getProxy();
		s.one();
		s.two();
		s.oneTwo();
		s.add(2.3, 3.4);
	}
}
