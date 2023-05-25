package com.appcoy.student.api.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CentralLogging {
    private static final Logger logger = LoggerFactory.getLogger(CentralLogging.class);

    @Before("execution(* com.appcoy.student.api.*.*.*(..))")
    public void handleLoggingBeforeInvocation(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Executing method: {}.{}", className, methodName);
    }
}