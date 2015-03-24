package com.trainings.beans;

import org.apache.log4j.Logger;

public class HardDisk implements Device {

    private static final Logger LOG = Logger.getLogger(HardDisk.class);

    public HardDisk() {
        LOG.info("Create (0) ");
    }

    public HardDisk(String name) {
        LOG.info("Create (1): "+name);
        this.name = name;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void initDefaults() {
        setName("NO-NAME");
    }

    @Override
    public String toString() {
        return "HardDisk{" +
                "name='" + name + '\'' +
                '}';
    }


}
