package com.trainings.spring.bean;

import java.util.LinkedList;
import java.util.List;

public class Computer {

	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}
	
	public void addDevice(Device device){
		if(devices == null){
			this.devices = new LinkedList<Device>();
		}
		this.devices.add(device);
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "Computer [devices=" + devices + "]";
	}
}
