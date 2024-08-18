package com.nura.aopdemo.aspects;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nura.aopdemo.bean.Account;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

	// the name should exactly match including the parenthesis
	@Before("com.nura.aopdemo.aspects.myAopAspects.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n +++++++++++=> CAlling @Before Advice before calling the method.");

		// Collect Method Signature using JoinPoints in the advices
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature:" + methodSignature);

		// Collect the Arguments of the method using JoinPoint
		Object[] args = theJoinPoint.getArgs();
		System.out.println(Arrays.toString(args));

	}

	// the name should exactly match including the parenthesis
	@AfterReturning(pointcut = "execution(* com.nura.aopdemo.dao.AccountDAOImpl.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();

		System.out.println("====> Executing @AfterReturn on method: " + method);

		System.out.println("=before processing===> Results:: " + result);

		for (Account a : result) {
			String name = a.getName().toUpperCase();
			a.setName(name);
		}

	}

	@AfterThrowing(pointcut = "execution(* com.nura.aopdemo.dao.AccountDAOImpl.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		String method = theJoinPoint.getSignature().toShortString();

		System.out.println("====> Executing @AfterThrowing on method: " + method);

		System.out.println("=Exception while executing the above method. Exception: " + theExc);

	}

	@Around("execution(* com.nura.aopdemo.service.TrafficFortuneServiceImpl.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint theProJoinPoint) throws Throwable {

		Object result = null;

		String method = theProJoinPoint.getSignature().toShortString();

		System.out.println("\n\n====> Executing @Around advice on method: " + method);

		try {
			result = theProJoinPoint.proceed();
		} catch (Exception e) {
			System.out.println("@Around advice we have a problem." + e);
			throw e;
		}

		return result;
	}

}
