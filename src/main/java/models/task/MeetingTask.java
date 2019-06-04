package models.task;

import models.util.Person;
import java.util.Date;
import java.util.HashSet;

public class MeetingTask extends BaseTask {

    protected Date startingTime;

    protected HashSet<Person> attendees;

    public MeetingTask()
    {

    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public HashSet<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(HashSet<Person> attendees) {
        this.attendees = attendees;
    }

    public MeetingTask( String name, Date dueDate, Priority priority, Date startingTime) {
        super(name, dueDate, priority);
        attendees = new HashSet<>();
        this.startingTime = startingTime;
    }
}
