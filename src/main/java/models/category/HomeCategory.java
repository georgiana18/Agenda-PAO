package models.category;

import models.util.Event;
import models.util.Invoice;

import java.util.ArrayList;

public class HomeCategory extends BaseCategory {

    ArrayList<Event> events;

    ArrayList <Invoice> invoiceList;

    public ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public HomeCategory()
    {

    }

}
