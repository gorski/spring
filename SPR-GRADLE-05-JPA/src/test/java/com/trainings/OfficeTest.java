package com.trainings;


import com.trainings.beans.InvoiceSystem;
import com.trainings.beans.Office;
import com.trainings.springconfig.AppConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class OfficeTest {

    @Autowired
    @InjectMocks
    Office office;

    @Mock
    InvoiceSystem invoiceSystem;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void officeTest() {
        Assert.assertNotNull(invoiceSystem);
        when(invoiceSystem.commit()).thenReturn(6);
        when(invoiceSystem.getInvoiceAmount(1)).thenReturn(10);

        Assert.assertEquals(6, office.inspect());
        Assert.assertEquals(10, invoiceSystem.getInvoiceAmount(1));
        verify(invoiceSystem).commit();
    }




}
