package com.trainings.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Component
@XmlRootElement(name = "info")
public class SystemInformation {

    @Value("${hello.message}")
    private String hello;

    @Value("#{ systemProperties['os.name'] }")
    private String osName;

    @Value("#{ systemProperties['java.version'] }")
    private String javaVersion;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
}
