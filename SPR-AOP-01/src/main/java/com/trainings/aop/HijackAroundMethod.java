package com.trainings.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HijackAroundMethod implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Object[] arguments = methodInvocation.getArguments();
		for (Object argument : arguments) {
			if (argument.toString().contains("drop")){
				throw new IllegalArgumentException("!");
			}
		}

		// same with MethodBeforeAdvice
		System.out.println("HijackAroundMethod : Before method hijacked!");

		try {
			// proceed to original method call
			Object result = methodInvocation.proceed();

			// same with AfterReturningAdvice
			System.out.println("HijackAroundMethod : Before after hijacked!");

			return result;

		} catch (IllegalArgumentException e) {
			// same with ThrowsAdvice
			System.out
					.println("HijackAroundMethod : Throw exception hijacked!");
			throw e;
		}
	}
}