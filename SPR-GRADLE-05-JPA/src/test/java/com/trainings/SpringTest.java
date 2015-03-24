package com.trainings;

import com.trainings.beans.Computer;
import com.trainings.springconfig.AppConfig;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class SpringTest {

    private static final Logger LOG = Logger.getLogger(SpringTest.class);

    @Autowired
    private Computer computer;

    @Before
    public void setUp() {
        Assert.assertNotNull(computer);
    }

    @Test
//    @DirtiesContext
    public void test() {
        Assert.assertNotNull(computer.getDevices());
        Assert.assertEquals(2, computer.getDevices().size());
    }
}
