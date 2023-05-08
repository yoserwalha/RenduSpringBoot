package tn.esprit.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Aspect
@Slf4j
public class LoggingAspect {
	private static final Logger l = LogManager.getLogger(LoggingAspect.class);


	@Before("execution(public * tn.esprit.spring.service.*.* (..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		log.info("In method : " + joinPoint.getSignature().getName() + " : ");
	}

	@AfterReturning("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit1(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("Out of method without errors : " + name );
	}

	@AfterThrowing("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit2(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.error("Out of method with erros : " + name );
	}

	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		log.info("Out of method : " + name );
	}

	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		l.info("Method execution time: " + elapsedTime + " milliseconds.");
		return obj;
	}

}