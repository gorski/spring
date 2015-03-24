package com.trainings.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceAspect {

	private static final Logger LOG = Logger.getLogger(TraceAspect.class);

	@Around("com.trainings.spring.aop.SystemArchitecture.inControllers()")
	public Object operation(final ProceedingJoinPoint pjp) throws Throwable {
		LOG.debug("Controller method " + pjp.getSignature());
		final Object retVal = pjp.proceed();
        System.out.println("!!!!");
		return retVal;
	}

	@Around("com.trainings.spring.aop.SystemArchitecture.inToString()")
	public Object publicGetters(final ProceedingJoinPoint pjp) throws Throwable {
		LOG.debug("toString() method of " + pjp.getSignature());
		final Object retVal = pjp.proceed();
		return retVal;
	}

	// @Around("com.trainings.spring.aop.SystemArchitecture.inAllLayers()")
	// public Object doTracing(final ProceedingJoinPoint pjp) throws Throwable {
	//
	// LOG.debug("BEFORE ***** " + pjp.getSignature());
	// final Object retVal = pjp.proceed();
	//
	// LOG.debug("AFTER ***** " + pjp.getSignature());
	// return null;
	//
	// }

}
