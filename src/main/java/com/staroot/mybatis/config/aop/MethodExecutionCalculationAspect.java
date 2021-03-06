package com.staroot.mybatis.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect	
@Component
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.staroot.mybatis.controller.*.*(..))")
	public void before(JoinPoint joinPoint) throws Throwable {
		logger.debug("[AOP LOGGING TEST 11111111111111111111] onBeforeHandler {}", joinPoint);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@After("execution(* com.staroot.mybatis.controller.*.*(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		logger.debug("[AOP LOGGING TEST 22222222222222222222]  onAfterHandler");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	/*
	@Around("execution(* com.staroot.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.debug("[AOP LOGGING TEST 11111111111111] Time Taken by {} is {}", joinPoint, timeTaken);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	@Around("execution(* com.staroot.mybatis.controller.*.*(..))")
	public void around2(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.debug("[AOP LOGGING TEST 11111111111111] Time Taken by {} is {}", joinPoint, timeTaken);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Before("execution(* com.staroot.*.*(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		logger.debug("=============== onBeforeThing");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	*/
	
}