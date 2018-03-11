package com.ikook.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类，在此编写通知
 * 基于注解实现 AOP 编程
 *
 * 该类作为组件使用，所以要添加 @Component 注解才能生效。
 */
@Aspect
@Component   // Component 表示一个组件（Bean）.
public class MyAspect {

    // 用于取代： <aop:pointcut
    // expression="execution(* cn.itcast.dao..*.*(..))" id="myPointCut"/>
    // 要求： 方法必须是 private 没有值 名称自定义 ，没有参数
    @Pointcut("execution(* com.ikook.dao..*.*(..))")
    private void myPointCut() {
    }

    // 前置通知
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.print("前置通知 ，目标：");
        System.out.print(joinPoint.getTarget() + ", 方法名称：");
        System.out.println(joinPoint.getSignature().getName());
    }

    // 后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("后置通知,方法名称：" + joinPoint.getSignature().getName());
    }

    // 环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        // 开始
        System.out.println("环绕开始");
        // 执行当前目标方法
        Object obj = proceedingJoinPoint.proceed();
        // 结束
        System.out.println("环绕结束");

        return obj;
    }

    // 异常通知
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知" + "出错了" + e.getMessage());
    }

    // 最终通知
    @After("myPointCut()")
    public void myAfter() {
        System.out.println("最终通知");
    }


}
