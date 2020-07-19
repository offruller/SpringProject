package by.iba.grigorjev.springproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(by.iba.grigorjev.springproject.aop.LogAnnotation)")

    public void callAtPersonController() {
    }

    @Before("callAtPersonController()")
    public void beforeCallMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtPersonController()")
    public void afterCallAt(JoinPoint jp) {
        log.info("after " + jp.toString());
    }

    @Around("callAtPersonController()")
    public Object aroundCall(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = jp.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Метод "+ jp.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }


}
