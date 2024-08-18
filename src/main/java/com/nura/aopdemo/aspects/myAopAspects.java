package com.nura.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myAopAspects {

	// Create a pointcut declarations to be used in multiple Advices.
	@Pointcut("execution(* com.nura.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {
	}

	@Pointcut("execution(* com.nura.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.nura.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {
	}

}
