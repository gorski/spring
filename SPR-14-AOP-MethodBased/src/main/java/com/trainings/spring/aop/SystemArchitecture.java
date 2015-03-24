package com.trainings.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemArchitecture {

	private static final Logger LOG = Logger.getLogger(SystemArchitecture.class);
	
  @Pointcut("within(com.trainings.spring.controllers..*)")
  public void inControllers() {}

  @Pointcut("execution(public * com.trainings.spring.web..*.toString*())")
  public void inToString() {}

}
