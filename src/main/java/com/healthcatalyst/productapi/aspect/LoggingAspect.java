package com.healthcatalyst.productapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // intercept every method in your service package
    @Around("execution(* com.healthcatalyst.productapi.service..*(..))")
    public Object logAroundService(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Calling: {} with args {}", joinPoint.getSignature(), joinPoint.getArgs());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long elapsed = System.currentTimeMillis() - start;
        logger.info("Completed: {} in {} ms → returned {}",
                joinPoint.getSignature(), elapsed, result);
        return result;
    }

}
