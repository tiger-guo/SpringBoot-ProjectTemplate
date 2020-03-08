package com.organization.projectName.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @program: springboot-learn-shiyanlou
 * @description: AOP
 * @author: liuguohu
 * @create: 2020-03-07 21:03
 **/

//@Aspect
//@Component
public class SpringBootAop {


    //设置切点
    @Pointcut(value = "execution(* com.shiyanlou.springboot..*.run(..))")
    public void aop() {
    }

    @Before("aop()")
    public void before() {
        System.out.println("before：执行方法前");
    }


    @After("aop()")
    public void after() {
        System.out.println("after：执行方法后");
    }


    @AfterThrowing("aop()")
    public void afterThrowing() {
        System.out.println("afterThrowing：异常抛出后");
    }

    @AfterReturning("aop()")
    public void afterReturning() {
        System.out.println("afterReturning：方法返回后");
    }

    @Around("aop()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around：环绕通知前");
        //执行方法
        joinPoint.proceed();
        System.out.println("around：环绕通知后");

    }
}