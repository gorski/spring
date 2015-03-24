package com.trainings.springconfig;

import com.trainings.beans.Device;
import com.trainings.beans.HardDisk;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.trainings.service"} )
@ImportResource("classpath:spring.xml")
public class PersistentAppConfig {

}
