package models.util;

import java.util.Date;

public class Project {

    protected int id ;

    public String name;

    public Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(Date dueDate, String name) {
        this.dueDate = dueDate;
        this.name = name;
    }
}
