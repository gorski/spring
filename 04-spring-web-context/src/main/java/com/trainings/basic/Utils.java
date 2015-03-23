package com.trainings.basic;


import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Utils {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Utils.class);

    public void listCtx(ApplicationContext ctx) {

        LOG.debug("----------------------");
        LOG.debug("Ctx id {}", ctx.getDisplayName());
        LOG.debug("Bean count {} ", ctx.getBeanDefinitionCount());
        String[] beans = ctx.getBeanDefinitionNames();
        for (String b : beans) {

            Object bean = ctx.getBean(b);
            boolean singleton = ctx.isSingleton(b);

            StringBuffer sb = new StringBuffer();
            sb.append(singleton ? "[S] " : "[P] ");
            if (bean.getClass().toString().contains("com.trainings")) {
                sb.append(" PROJECT  ");
            } else {
                sb.append(" EXTERNAL ");
            }
            sb.append(bean.getClass());

            LOG.debug(sb.toString());
        }

        ApplicationContext parent = ctx.getParent();
        if (parent != null) {
            LOG.info("This bean has a parent, about to list {}", parent.getId());
            listCtx(parent);

        }
    }

}
