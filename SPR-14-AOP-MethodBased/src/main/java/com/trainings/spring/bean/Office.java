package com.trainings.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Office {

	// public Office() {
	// }

	// @Autowired
	// public Office( Computer computer) {
	// this.computer = computer;
	// System.out.println("by constructor");
	//
	// }

	@Autowired
	private Computer computer;

	@Autowired
	@Qualifier("wdHardDisk")
	private Device device;

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "Office [computer=" + computer + ", wdHardDisk=" + device + "]";
	}

}
