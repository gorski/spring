package com.trainings.spring.util;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Utils {

	private static final Logger LOG = Logger.getLogger(Utils.class);
	
    private Utils() {}
    public static void listCtx(ApplicationContext ctx) {

    	LOG.debug("----------------------");
    	LOG.debug("Ctx id: " + ctx.getDisplayName());
    	LOG.debug("Bean count: " + ctx.getBeanDefinitionCount());
        String[] beans = ctx.getBeanDefinitionNames();
//        if (ctx instanceof XmlWebApplicationContext){
//        	((XmlWebApplicationContext) ctx).get
//        }
        for (String b : beans) {

            Object bean = ctx.getBean(b);
            boolean singleton = ctx.isSingleton(b);


            StringBuffer sb = new StringBuffer();
            sb.append(singleton ? "[S] " : "[P] ");
            if (bean.getClass().toString().contains("com.trainings")) {
                sb.append(" + ");
            } else {
                sb.append(" > ");
            }
            sb.append(bean.getClass());

            LOG.debug(sb.toString());
        }

        ApplicationContext parent = ctx.getParent();
        if (parent != null) {
            listCtx(parent);
        }
    }

}
