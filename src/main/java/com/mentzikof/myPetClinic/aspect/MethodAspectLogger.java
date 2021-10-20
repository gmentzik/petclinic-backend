package com.mentzikof.myPetClinic.aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MethodAspectLogger {
	
	private static final String LOG_METHOD_INPUT_DATA_ANNOTATION = "@annotation(com.mentzikof.myPetClinic.annotation.LogMethodInputData)";
	private static final String LOG_METHOD_EXCEPTION_ANNOTATION = "@annotation(com.mentzikof.myPetClinic.annotation.LogMethodException)";
	private static final String LOG_METHOD_EXECUTION_TIME_ANNOTATION = "@annotation(com.mentzikof.myPetClinic.annotation.LogMethodExecutionTime)";

	@Before(value = LOG_METHOD_INPUT_DATA_ANNOTATION)
	public void beforeAdvice(JoinPoint jp) {
		log.info("Before: {} ", constructLogMsg(jp));
	}

    @AfterThrowing(pointcut = LOG_METHOD_EXCEPTION_ANNOTATION, throwing = "e")
    public void logAfterException(JoinPoint jp, Exception e) {
        log.error("Exception during: {} with ex: {}", constructLogMsg(jp),  e.toString());
    }
	
	@Around(value = LOG_METHOD_EXECUTION_TIME_ANNOTATION)
	public Object logExecutionTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = jp.proceed();
		long executionTime = System.currentTimeMillis() - start;
		log.info("Around: {} ", constructExecutionTimeLogMsg(jp, executionTime));
		return proceed;
	}

	
    private String constructExecutionTimeLogMsg(JoinPoint jp, long executionTime) {
		var sb = new StringBuilder("@");
        sb.append(jp.getSignature());
        sb.append(":");
        sb.append(" executed in " + executionTime + "ms");
        return sb.toString();
    }
	
    private String constructLogMsg(JoinPoint jp) {
        var args = Arrays.asList(jp.getArgs()).stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        var sb = new StringBuilder("@");
        sb.append(jp.getSignature());
        sb.append(":");
        sb.append(args);
        return sb.toString();
    }
}
