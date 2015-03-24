package com.trainings.spring.aop;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("myMethodBeforeAdvice")
public class MyMethodBeforeAdvice implements org.springframework.aop.MethodBeforeAdvice {

    private static final Logger LOG = Logger.getLogger(MyMethodBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        LOG.debug("Method:"+method+", args:"+args+", target:"+target);
    }
}
