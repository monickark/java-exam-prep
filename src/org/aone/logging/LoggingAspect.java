package org.aone.logging;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	final  Logger logger = Logger.getLogger(LoggingAspect.class.getName());


	//Logger Aspect  to Get product search Display before Value
	@Before("execution(* org.aone.*.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.debug("Log Before : "+ joinPoint.getSignature().getDeclaringType().getName()+","+ joinPoint.getSignature().getName());
		
	}
	
	
	//Logger Aspect to get Product search Display after Value
	@After("execution(*  org.aone.*.*.*(..))")
	public void after(JoinPoint joinPoint) {
		  logger.debug("Log After : " + joinPoint.getSignature().getName()+" finished");

	
	}

	//Logger Aspect to get product Search Display Return type value
	@AfterReturning(pointcut="execution(*  org.aone.*.*.*(..))", returning="ret")
	public void returnValue(JoinPoint joinPoint,Object ret){
		  logger.debug("Return type method :" + joinPoint.getSignature().getName()+", value : "+ret);

    }
	
	
	//Logger Aspect to get product search Display exception throwing value
	@AfterThrowing(pointcut = "execution(*  org.aone.*.*.*(..))", throwing = "e")
    public void throwsException(JoinPoint joinPoint,Throwable e){
		  logger.debug("Exception Method: " + joinPoint.getSignature().getName()+", value :"+e);

		
	}
	
	
	
}