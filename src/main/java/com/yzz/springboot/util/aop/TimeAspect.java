package com.yzz.springboot.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : Yangzhengzheng
 * @Date : Created in 14:02 2018/11/20
 * @Description:
 * @Modified By: 使用 @Component，@Aspect 标记到切面类上：
 */
@Aspect
@Component
public class TimeAspect {

	@Around("execution(* com.yzz.springboot.controller.FastJsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("=====Aspect处理=======");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("参数为:" + arg);
		}

		long start = System.currentTimeMillis();

		Object object = pjp.proceed();

		System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

		return object;
	}
}
