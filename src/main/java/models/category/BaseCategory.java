package models.category;

import models.task.BaseTask;

import java.util.ArrayList;

abstract public class BaseCategory {

    protected  int id;

    protected String name;

    protected String description;

    protected ArrayList<BaseTask> tasks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BaseCategory()
    {
        tasks = new ArrayList<BaseTask>();
    }

    public BaseCategory(String name, String description)
    {
        this.name = name;
        this.description = description;
        tasks = new ArrayList<BaseTask>();
    }

    public ArrayList<BaseTask> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<BaseTask> tasks) {
        this.tasks = tasks;
    }
}
