package com.example.library;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.example.library.LibraryService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long end = System.nanoTime();
            String method = pjp.getSignature().toShortString();
            System.out.println("[EXE3-LOG] " + method + " executed in " + ((end - start) / 1_000_000.0) + " ms");
        }
    }
}
