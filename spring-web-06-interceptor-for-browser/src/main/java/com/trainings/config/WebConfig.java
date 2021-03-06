package com.trainings.config;

import com.trainings.basic.interceptors.BrowserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.trainings.controller"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    BrowserInterceptor executeTimeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // this interceptor will only handle links matching pattern ...

        // method       -> only /method
        // /admin/*     -> /admin/1 or /admin/2 but not /admin/user/sss
        // /admin/**    -> catches /admin/sth/els/...

        registry.addInterceptor(executeTimeInterceptor).addPathPatterns("/forNiceBrowsersOnly");

    }


    @Bean
    public static PropertyPlaceholderConfigurer configurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("app.properties"));
        return ppc;
    }

}
