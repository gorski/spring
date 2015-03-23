package com.trainings.spring.bean;

public class HardDisk implements Device {

	private String name;

	public HardDisk() {
	}

	public HardDisk(String name) {
		System.out.println("create hard disk: "+ name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HardDisk [name=" + name + "]";
	}
	
	public static HardDisk createBean(){
		return new HardDisk("samsung");
	}
}
