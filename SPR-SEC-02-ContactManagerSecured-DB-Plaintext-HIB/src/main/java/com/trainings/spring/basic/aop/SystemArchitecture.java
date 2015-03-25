package com.trainings.spring.basic.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemArchitecture {

  @Pointcut("within(com.trainings.spring.basic.controllers..*)")
  public void inControllers() {}

  /**
   * A join point is in the service layer if the method is defined in a type
   * in the com.trainings.spring.basic.service package or any sub-package under that.
   */
  @Pointcut("within(com.trainings.spring.basic.service..*)")
  public void inServiceLayer() {}

  /**
   * A join point is in the data access layer if the method is defined in a type
   * in the com.trainings.spring.basic.dao package or any sub-package under that.
   */
  @Pointcut("within(com.trainings.spring.basic.dao..*)")
  public void inDataAccessLayer() {}

  @Pointcut("inControllers() || inServiceLayer()")
  public void inAllLayers() {}

  @Pointcut("execution(public String com.trainings.spring.basic.controllers.*Controller.*(..))")
  public void anyPublicOperation() {}

}
