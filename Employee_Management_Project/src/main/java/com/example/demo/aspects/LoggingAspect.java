package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	@Before("execution(*com.example.demo.*(...))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Entering Method:"+joinPoint.getSignature().getClass());
	}
	@After("execution(*com.example.demo...*(..))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Exiting Method:"+joinPoint.getSignature().getClass());
	}
}
