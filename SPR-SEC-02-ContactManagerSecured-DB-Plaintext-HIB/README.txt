

First import MySQL schema from /config/*.ddl
jdbc.properties -> MySql credentials

Security:
- spring-security.xml
- TraceAspect - injecting user info


Extra feature:
- i18n - spring-servlet.xml --> look for "locale"


changing lang:
1.. look for "paramName"
    <bean id="localeChangeInterceptor"
          class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
        <property name="paramName" value="locale" />
2. call any url : ?locale=pl etc.