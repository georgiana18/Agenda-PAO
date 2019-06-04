package models.util;

import java.util.Date;

public class Event {

    private int id;

    private Date dateToRemember;

    private String name;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateToRemember() {
        return dateToRemember;
    }

    public void setDateToRemember(Date dateToRemember) {
        this.dateToRemember = dateToRemember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Event()
    {

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event(Date dateToRemember, String name, String description) {
        this.dateToRemember = dateToRemember;
        this.name = name;
        this.description = description;
    }
}
