package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author yulshi
 * @create 2020/06/04 14:06
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.example.aop.servcie.Calculator.*(..))")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("Before " + joinPoint.getSignature().getName()
                + " with parameters {" + Arrays.toString(joinPoint.getArgs()) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("After " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("After returning " + joinPoint.getSignature().getName()
                + " with returning " + "{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logThrowning(JoinPoint joinPoint, Exception exception) {
        System.out.println("After throwing " + joinPoint.getSignature().getName()
                + " with exception {" + exception + "}");
    }

    @Around("pointCut()")
    private Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("~~~~~~~~~");
        Object obj = joinPoint.proceed();
        System.out.println("###########");
        return obj;
    }

}
