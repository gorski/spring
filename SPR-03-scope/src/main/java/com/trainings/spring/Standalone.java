package com.trainings.spring;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trainings.spring.bean.Computer;
import com.trainings.spring.bean.Device;
import com.trainings.spring.bean.HardDisk;

public class Standalone {

	public static void main(String... args) {
		//
//		List<Device> devices = new LinkedList<Device>();
//		devices.add(new HardDisk("segate"));
//		devices.add(new HardDisk("wd"));
//
//		Computer computer1 = new Computer();
//		computer1.setDevices(devices);
//
//		System.out.println(computer1);

		// spring
		ConfigurableApplicationContext xmlContext = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml" });

		System.out.println("Computer:" + xmlContext.getBean(Computer.class));

		System.out.println("Device:"
				+ xmlContext.getBean("wdHardDisk", Device.class));
		
		System.out.println("Device:"
				+ xmlContext.getBean("wdHardDisk", Device.class));
		
		System.out.println("Device:"
				+ xmlContext.getBean("wdHardDisk", Device.class));
		
		System.out.println("Device:"
				+ xmlContext.getBean("samsungHardDisk", Device.class));
		System.out.println("Device:"
				+ xmlContext.getBean("samsungHardDisk", Device.class));
		System.out.println("Device:"
				+ xmlContext.getBean("samsungHardDisk", Device.class));

		String[] beanDefinitionNames = xmlContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName + ":" +xmlContext.isSingleton(beanName));
		}
	}

}
