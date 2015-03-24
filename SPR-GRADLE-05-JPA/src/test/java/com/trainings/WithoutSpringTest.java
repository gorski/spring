package com.trainings;

import com.trainings.beans.HardDisk;
import junit.framework.Assert;
import org.junit.Test;


public class WithoutSpringTest {


    @Test
    public void test() {
        HardDisk hd = new HardDisk("wd2");
        hd.setName("wd");

        Assert.assertEquals("Wrong name", "wd", hd.getName());

    }

}
