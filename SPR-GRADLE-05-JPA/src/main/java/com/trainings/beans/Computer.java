package com.trainings.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("pc")
public class Computer {

    private static final Logger LOG = Logger.getLogger(Computer.class);
    private Device device;

    @Autowired
    @Value("#{devicesList}")
//    @Qualifier("devicesList")
    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "devices=" + devices +
                '}';
    }
}
