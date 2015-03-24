package com.trainings.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Office {

    private static final Logger LOG = Logger.getLogger(Office.class);

    @Autowired
    private Computer computer;

    private InvoiceSystem invoiceSystem;

    @Autowired
    public void setInvoiceSystem(InvoiceSystem invoiceSystem) {
        this.invoiceSystem = invoiceSystem;
    }

    @Qualifier("wdHardDisk")
    @Autowired
    private Device hardDisk;

    public Office() {
        LOG.info("Create Office (0)");
    }

    public Office(Computer computer) {
        LOG.info("Create Office (1)");
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Device getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Device hardDisk) {
        this.hardDisk = hardDisk;
    }


    // complicated method
    public int inspect() {
        int size = computer.getDevices().size();
        int invoiceNo = invoiceSystem.commit();
        System.out.println("Computers:" + size + ", invoice:" + invoiceNo);

        return invoiceNo;
    }

    @Override
    public String toString() {
        return "Office{" +
                "computer=" + computer +
                ", hardDisk=" + hardDisk +
                '}';
    }
}
