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
@ComponentScan(basePackages = {"com.trainings.beans"} )
@ImportResource("classpath:spring.xml")
public class AppConfig {

    private static final Logger LOG = Logger.getLogger(AppConfig.class);

    @Bean(name = "wdHardDisk")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HardDisk createBeanWd() {
        return new HardDisk("wd");
    }

    @Bean(name = "lgHardDisk")
    public HardDisk createBeanLg() {
        return new HardDisk("lg");
    }

    @Bean(name = "samsungHardDisk")
    public HardDisk createBeanSamsung(@Qualifier("wdHardDisk") HardDisk other) {
        LOG.info("Other: " + other);
        return new HardDisk("samsung");
    }

    @Bean(name = "noNameDisk", initMethod = "initDefaults")
    public HardDisk createNoName() {
        return new HardDisk();
    }

    @Bean
    public List<Device> devicesList(
            @Qualifier("lgHardDisk") HardDisk lgHardDisk,
            @Qualifier("wdHardDisk") HardDisk wdHardDisk,
            @Qualifier("segate") HardDisk segateHardDisk
    ) {

        List<Device> devices = new ArrayList<Device>();
        devices.add(lgHardDisk);
        devices.add(wdHardDisk);
        devices.add(segateHardDisk);
        return devices;
    }


}
