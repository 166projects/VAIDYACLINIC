package com.mphasis.training.conf;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AspectHelper {

	@Before("execution(* com.mphasis.training.*.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("Aspect called");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@After("execution(* com.mphasis.training.*.*.*(..))")
	public void afterMethod(JoinPoint joinpoint) {
		System.out.println("Aspect called after");
		System.out.println(joinpoint.getSignature().getName());
	}

	final static Logger logger = Logger.getLogger(AspectHelper.class);

	@Pointcut(value = "execution(* com.mphasis.training.controller.*.*(..))")
	public void myPointCut() {
	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		logger.info("method invoked " + methodName + "Class Name " + className + "arguments: "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		logger.info("Class Name " + className + " methodname " + methodName + " Response "
				+ mapper.writeValueAsString(object));
		return object;

	}
}
