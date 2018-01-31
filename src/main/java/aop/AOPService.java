package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * aop配置：
 * 1.引入aspectjrt、aspectjweaver两个jar包
 * 2.spring-service.xml:开启aop注解,注意xmlns:aop、schema需要配置
 * 3.五种aop增强:切入点execution(* com.service.*.*(..))  包.包.类.方法(参数)
 * @author wsz
 * @date 2018年1月31日
 */
@Component
@Aspect
public class AOPService {

	@Before("execution(* service.*.*(..))")
	public void beforeAOP() {
		System.out.println("前置");
	}
	
	@After("execution(* service.*.*(..))")
	public void afterAOP() {
		System.out.println("后置");
	}
	
	@AfterReturning(returning="rvt",pointcut="execution(* service.*.*(..))")
	public void afterReturnAOP(Object rvt) {
		System.out.println("afterReturning:"+rvt);
	}
	
	@AfterThrowing(throwing="e",pointcut="execution(* service.*.*(..))")
	public void afterThrowAOP(Throwable e) {
		System.out.println("afterThrowing"+e);
	}
	
	@Around("execution(* service.*.*(..))")
	public Object  aroundAOP(ProceedingJoinPoint  jp) throws Throwable {
		System.out.println("环绕增强");
		Object rvt = jp.proceed();
		return rvt;
	}
	
	
}
