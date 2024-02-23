package com.example.common;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final LoggingProducer loggingProducer;
    private final static String KAFKA_LOGGING_KEY = "logging";

    @Before("execution(* com.example.*.adapter.in.web.*.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        loggingProducer.sendMessage(KAFKA_LOGGING_KEY, "before excution of " + methodName);
    }

}
