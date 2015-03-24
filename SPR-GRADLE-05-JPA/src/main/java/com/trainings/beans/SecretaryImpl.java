package com.trainings.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SecretaryImpl implements Secretary {

    private InvoiceSystem invoiceSystem;

    @Autowired
    public SecretaryImpl(InvoiceSystem invoiceSystem) {
        this.invoiceSystem = invoiceSystem;
    }

    @Override
    public int commit(){
        return 10 * invoiceSystem.commit();
    }

    @Override
    public int getAmount(int id){
        return 10 * invoiceSystem.getInvoiceAmount(id);
    }

    public InvoiceSystem getInvoiceSystem() {
        return invoiceSystem;
    }

    public void setInvoiceSystem(InvoiceSystem invoiceSystem) {
        this.invoiceSystem = invoiceSystem;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "invoiceSystem=" + invoiceSystem +
                '}';
    }
}
