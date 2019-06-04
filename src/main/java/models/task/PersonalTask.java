package models.task;

import java.util.Date;

public class PersonalTask extends BaseTask{

    private String location;

    private String description;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PersonalTask()
    {

    }

    public PersonalTask(int categoryId, String name, Date dueDate, Priority priority,String location) {
        super( name, dueDate, priority);
        this.location = location;
    }
}
