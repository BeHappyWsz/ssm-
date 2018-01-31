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
 * aop���ã�
 * 1.����aspectjrt��aspectjweaver����jar��
 * 2.spring-service.xml:����aopע��,ע��xmlns:aop��schema��Ҫ����
 * 3.����aop��ǿ:�����execution(* com.service.*.*(..))  ��.��.��.����(����)
 * @author wsz
 * @date 2018��1��31��
 */
@Component
@Aspect
public class AOPService {

	@Before("execution(* service.*.*(..))")
	public void beforeAOP() {
		System.out.println("ǰ��");
	}
	
	@After("execution(* service.*.*(..))")
	public void afterAOP() {
		System.out.println("����");
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
		System.out.println("������ǿ");
		Object rvt = jp.proceed();
		return rvt;
	}
	
	
}
