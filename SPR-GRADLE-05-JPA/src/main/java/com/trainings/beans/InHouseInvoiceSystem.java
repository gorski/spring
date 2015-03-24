package com.trainings.beans;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("invoiceSystem")
public class InHouseInvoiceSystem implements InvoiceSystem {

    private static final Logger LOG = Logger.getLogger(InHouseInvoiceSystem.class);

    @Override
    public int commit() {
        LOG.info("Invoice commit!");
        return new Random().nextInt();
    }

    @Override
    public int getInvoiceAmount(int invoiceId) {
        LOG.info("Getting amount of invoice with id: " + invoiceId);
        return invoiceId * 100;
    }
}
