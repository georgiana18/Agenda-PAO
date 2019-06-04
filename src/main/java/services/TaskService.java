package services;

import models.task.BaseTask;
import models.task.MeetingTask;
import models.task.PaymentTask;
import models.util.Invoice;
import models.util.Person;
import models.util.Project;
import services.Writer.Audit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class TaskService {

    public BaseTask AddPersonToMeeting (MeetingTask task, Person person)
    {
        Audit audit = new Audit("Added " + person.getName() + " to meeting");
        HashSet<Person> attendees = task.getAttendees();
        attendees.add(person);
        task.setAttendees(attendees);

        return task;
    }

    public boolean FindPersonFromMeeting (MeetingTask task, String name)
    {
        Audit audit = new Audit("Trying to find  " + name + " in the meeting list");
        HashSet <Person> attendees = task.getAttendees();
        for ( Person person:attendees) {
            if(person.getName() == name)
                return true;
        }
       return false;
    }

    public Project FindProjectByID(int id, List<Project> projects)
    {
        for( Project project: projects)
        {
            if(project.getId() == id)
                return project;
        }
        return null;
    }

    public BaseTask RemovePersonFromMeeting (MeetingTask task, Person person)
    {
        Audit audit = new Audit("Removed " + person.getName() + " from meeting list");
        HashSet<Person> attendees = task.getAttendees();
        attendees.remove(person);
        task.setAttendees(attendees);

        return task;
    }

    public PaymentTask AddNewInvoice (PaymentTask task, Invoice invoice)
    {
        Audit audit = new Audit("Added new invoice with number " + invoice.getNumber());
        ArrayList<Invoice> invoices = task.getInvoices();
        invoices.add(invoice);
        task.setInvoices(invoices);

        return  task;
    }

    public PaymentTask RemoveInvoice(PaymentTask task, String invoiceNumber)
    {
        Audit audit = new Audit("Removed invoice with number " + invoiceNumber);
        ArrayList<Invoice> invoices = task.getInvoices();
        ArrayList<Invoice> toRemove = new ArrayList<Invoice>();
        for (Invoice invoice: invoices)
        {
            if(invoice.getNumber() == invoiceNumber)
                toRemove.add(invoice);
        }
        invoices.removeAll(toRemove);
        task.setInvoices(invoices);
        return task;
    }
}
