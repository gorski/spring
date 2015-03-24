package com.trainings.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.trainings.controller"})
@ImportResource("/WEB-INF/spring-servlet.xml")
@EnableWebMvc
public class WebConfig {

    @Bean
    public static PropertyPlaceholderConfigurer configurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("app.properties"));
        return ppc;
    }

}
