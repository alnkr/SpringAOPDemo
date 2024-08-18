package com.nura.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class myApiAnalyticsAspect {

	// the name should exactly match including the parenthesis
	@Before("com.nura.aopdemo.aspects.myAopAspects.forDAOPackageNoGetterSetter()")
	public void performApiAnalyticsAdvice() {
		System.out.println("\n +++++++++++=> CAlling @Before performApiAnalyticsAdvice.");
	}

}
