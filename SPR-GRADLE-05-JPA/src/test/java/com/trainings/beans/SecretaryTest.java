package com.trainings.beans;


import com.trainings.beans.InvoiceSystem;
import com.trainings.beans.Secretary;
import com.trainings.springconfig.AppConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SecretaryTest {
    @Autowired

    @InjectMocks
    Secretary secretary;

    @Mock
    InvoiceSystem invoiceSystem;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void officeTest() {

        when(invoiceSystem.commit()).thenReturn(6);
        when(invoiceSystem.getInvoiceAmount(1)).thenReturn(200);

        Assert.assertEquals(60, secretary.commit());
        Assert.assertEquals(2000, secretary.getAmount(1));
//        Assert.assertEquals(2000, secretary.getAmount(2));
        verify(invoiceSystem).commit();
    }

    @Test
    public void threeTimesTest() {

        given(invoiceSystem.commit()).willReturn(60, 70, 80);

        Assert.assertEquals(600, secretary.commit());
        Assert.assertEquals(700, secretary.commit());
        Assert.assertEquals(800, secretary.commit());
        Assert.assertEquals(800, secretary.commit());

        verify(invoiceSystem, times(4)).commit();
    }


    //    @Test(expected = RuntimeException.class)
    @Test
    public void runtimeExceptionTest() {

        when(invoiceSystem.commit()).thenThrow(new RuntimeException("foo"));
        try {
            invoiceSystem.commit();
            Assert.fail();
        } catch (RuntimeException e) {
            Assert.assertEquals("foo", e.getMessage());
        }

    }

    @Test
    public void anyParamTest() {
        int INVOICE_AMOUNT = 50;
        when(invoiceSystem.getInvoiceAmount(anyInt())).thenReturn(5);

        Assert.assertEquals(INVOICE_AMOUNT, secretary.getAmount(4));
        Assert.assertEquals(INVOICE_AMOUNT, secretary.getAmount(33));
        Assert.assertEquals(INVOICE_AMOUNT, secretary.getAmount(411));
    }

    @Test
    public void stubTest() {
        when(invoiceSystem.getInvoiceAmount(anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                Integer arg0 = (Integer) arguments[0];
                return -arg0;
            }
        });
        Assert.assertEquals(-600, secretary.getAmount(60));
    }

    @Test
    public void resetTest() {
        given(invoiceSystem.commit()).willReturn(5);
        Assert.assertEquals(50, secretary.commit());
        Assert.assertEquals(50, secretary.commit());
        Assert.assertEquals(50, secretary.commit());
        Assert.assertEquals(50, secretary.commit());
        reset(invoiceSystem);
        verify(invoiceSystem, never()).commit();
    }

    @Test(expected = WantedButNotInvoked.class)
    public void timeoutTest() {

        waitAndCallCommit(600, invoiceSystem).start();
        verify(invoiceSystem, never()).commit();

        verify(invoiceSystem, timeout(300)).commit();
    }

    private Thread waitAndCallCommit(final int i, final InvoiceSystem invoiceSystem2) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // will run after i [ms]
                invoiceSystem2.commit();
            }
        });
    }


}
