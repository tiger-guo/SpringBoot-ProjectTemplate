package com.organization.projectName.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @program: springboot-learn-shiyanlou
 * @description:用aop进行事务控制
 * @author: liuguohu
 * @create: 2020-03-07 21:45
 **/
//@Component
public class AopTransaction {

    /**
     * 注入事务管理器
     */
    @Autowired
    public PlatformTransactionManager platformTransactionManager;

    /**
     * 设置事务拦截器
     */
    @Bean
    public TransactionInterceptor transactionInterceptortest() {
        //设置事务属性 可以通过它设置事务的基本属性，如事务是读写事务或者只读事务，事务的超时时间等
        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
        //设置为读写事务
        defaultTransactionAttribute.setReadOnly(false);
        //通过方法名匹配事务
        NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        //为save方法添加事务，事务属性为defaultTransactionAttribute设置的属性
        nameMatchTransactionAttributeSource.addTransactionalMethod("save", defaultTransactionAttribute);
        //新建一个事务拦截器，使用platformTransactionManager作为事务管理器，拦截的方法为nameMatchTransactionAttributeSource中匹配到的方法
        return new TransactionInterceptor(platformTransactionManager, nameMatchTransactionAttributeSource);
    }


    @Bean
    public Advisor advisor() {
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        //execution 表达式 匹配save方法
        aspectJExpressionPointcut.setExpression("execution(* com.shiyanlou.springboot.service.*.save(..))");
        //返回aop切面，切面=切点+通知
        return new DefaultPointcutAdvisor(aspectJExpressionPointcut, transactionInterceptortest());
    }
}
