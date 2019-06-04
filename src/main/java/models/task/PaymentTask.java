package models.task;

import models.util.Invoice;

import java.util.ArrayList;
import java.util.Date;

public class PaymentTask extends BaseTask {

    protected ArrayList<Invoice> invoices;

    protected Date timeStamp;

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public PaymentTask()
    {
        invoices = new ArrayList<Invoice>() ;
    }

    public PaymentTask(String name, Date dueDate, Priority priority) {
        super(name, dueDate, priority);
        invoices = new ArrayList<Invoice>();
    }
}
