package com.staroot.mybatis.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect	
@Component
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* com.staroot.*.*(..))")
	//@Around("execution(* com.staroot.mybatis.controller.TestController(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.debug("[AOP LOGGING TEST 11111111111111] Time Taken by {} is {}", joinPoint, timeTaken);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Before("execution(* com.staroot.*.*(..))")
	//@Before("execution(* com.staroot.mybatis.controller.TestController(..))")
	public void before(JoinPoint joinPoint) throws Throwable {
		logger.debug("[AOP LOGGING TEST 222222222222222] Allowed execution for {}", joinPoint);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	
	@Before("execution(* com.staroot.*.*(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		logger.debug("=============== onBeforeThing");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@After("execution(* com.staroot.*.*(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		logger.debug("=============== onAfterHandler");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}	
}