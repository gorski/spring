package com.trainings.spring.basic.controllers;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "root")
public class Test {

    private String inner = "inner text";

    public String getInner() {
        return inner;
    }

    public void setInner(String inner) {
        this.inner = inner;
    }
}
