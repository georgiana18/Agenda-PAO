package services;


import models.category.BaseCategory;
import models.task.BaseTask;
import services.Writer.Audit;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class cmpDueDate implements Comparator<BaseTask>
{
    public int compare(BaseTask o1, BaseTask o2) {
        return  o1.getDueDate().after(o2.getDueDate())? 1:0;
    }
}

public class CategoryService {

    public BaseCategory addMeeting(BaseCategory category, BaseTask task)
    {
        Audit audit = new Audit("Added meeting in " + category.getName() + " for task " + task.getName());
        ArrayList<BaseTask> tasks = category.getTasks();
        task.setStatus(BaseTask.Status.NEW);
        task.setCategoryId(category.getId());
        tasks.add(task);
        category.setTasks(tasks);

        return category;
    }

    public BaseCategory removeMeeting( BaseCategory category, BaseTask meetingTask)
    {
        Audit audit = new Audit("Removed meeting from " + category.getName() + " for task " + meetingTask.getName());
        ArrayList<BaseTask> tasks = category.getTasks();
        ArrayList<BaseTask> toRemove = new ArrayList<BaseTask>();
        for (BaseTask task: tasks)
        {
            if(task == meetingTask)
            {
              task.setStatus(BaseTask.Status.CANCELLED);
              toRemove.add(task);
            }
        }
        tasks.removeAll(toRemove);
        category.setTasks(tasks);
        return category;
    }

    public BaseCategory emptySchedule(BaseCategory category, Date date)
    {
        Audit audit = new Audit("Empty schedule for " + category.getName());
        ArrayList<BaseTask> tasks = category.getTasks();
        for (BaseTask task: tasks)
        {
            if(task.getDueDate()==date)
            {
                task.setStatus(BaseTask.Status.ONHOLD);
            }
        }
        return  category;
    }

    public BaseCategory sortTasks(BaseCategory category)
    {
        Audit audit = new Audit("Sort tasks for " + category.getName());
        ArrayList<BaseTask> tasks = category.getTasks();
        Collections.sort(tasks, new cmpDueDate());

        category.setTasks(tasks);
        return  category;
    }

}
