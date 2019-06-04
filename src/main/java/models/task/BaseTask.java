package models.task;

import java.util.Date;

abstract public class BaseTask {

    public enum Status
    {
        INPROGRESS,DONE,ONHOLD,NEW, CANCELLED
    }


    public enum Priority
    {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    protected  int id;

    protected int categoryId;

    protected String name;

    protected Date dueDate; //data limita

    protected Status status;

    protected Priority priority;

    public BaseTask()
    {

    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public BaseTask(String name, Date dueDate, Priority priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = Status.NEW;
    }

}
