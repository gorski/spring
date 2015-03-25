package com.trainings.spring.basic.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceAspect {

	private static final Logger LOG = Logger.getLogger(TraceAspect.class);

	@Around("com.trainings.spring.basic.aop.SystemArchitecture.inControllers()")
	public Object operation(final ProceedingJoinPoint pjp) throws Throwable {

		final Object retVal = pjp.proceed();

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username
		

		LOG.info("User : "+name);
		return retVal;

	}

	@Around("com.trainings.spring.basic.aop.SystemArchitecture.inAllLayers()")
	public Object doTracing(final ProceedingJoinPoint pjp) throws Throwable {

		LOG.info("ALL -  entering " + pjp.getSignature());
		final Object retVal = pjp.proceed();

		LOG.info("ALL -  leaving " + pjp.getSignature());
		return retVal;

	}

}
