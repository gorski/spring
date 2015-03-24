package com.trainings.spring.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
//@PropertySource(value = {"classpath:app.properties","classpath:/WEB-INF/jdbc.properties"})
public class AppConfig {

    @Value("#{ systemProperties['os.name'] }")
    private String osName;
    
    @Value("${company.website}")
    private String website;
    
    @Bean(name = "stopwatch")
    @Scope(value = "singleton")
    public Stopwatch createSingleton(){
        return new Stopwatch("stopwatch from AppConfig, " +
        		"running OS:"+osName
        		);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasenames("classpath:messages" /*, "classpath:messages/validation"*/);
//		// if true, the key of the message will be displayed if the key is not
//		messageSource.setUseCodeAsDefaultMessage(true);
//		messageSource.setDefaultEncoding("UTF-8");
//		// # -1 : never reload, 0 always reload
//		messageSource.setCacheSeconds(0);
//		return messageSource;
//	}
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor(){
//	    LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
//	    localeChangeInterceptor.setParamName("locale");
//	    return localeChangeInterceptor;
//	}
//
//	@Bean
//	public LocaleResolver getLocaleResolver(){
//	    return new CookieLocaleResolver();
//	}
//
//	<servlet>
//    <servlet-name>MyServlet</servlet-name>
//    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//    <init-param>
//        <param-name>contextClass</param-name>
//        <param-value>
//            org.springframework.web.context.support.AnnotationConfigWebApplicationContext
//        </param-value>
//    </init-param>
//    <init-param>
//        <param-name>contextConfigLocation</param-name>
//        <param-value>
//            com.web.AppConfig
//        </param-value>
//    </init-param>
//
//    <load-on-startup>1</load-on-startup>
//</servlet>




}
