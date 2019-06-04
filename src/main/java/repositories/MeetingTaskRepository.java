package repositories;

import connectivity.DatabaseConnection;
import models.category.BusinessCategory;
import models.task.BaseTask;
import models.task.MeetingTask;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingTaskRepository {
    private DatabaseConnection connection =
            DatabaseConnection.getInstance();

    public void saveTask(MeetingTask task) {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO meetingtasks VALUES (NULL,?,?,?,?,?,?)");

            statement.setString(1, task.getName());
            statement.setDate(2, new java.sql.Date(task.getDueDate().getTime()));
            statement.setString(3, task.getStatus().toString());
            statement.setString(4, task.getPriority().toString());
            statement.setDate(5,new java.sql.Date(task.getStartingTime().getTime()));
            statement.setString(6,null);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeeting(MeetingTask task)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("DELETE from meetingtasks WHERE Name = ? ");
            statement.setString(1,task.getName());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<MeetingTask> getAll()
    {
        List<MeetingTask> meetings = new ArrayList<>();
        try {

            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from meetingtasks");
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                MeetingTask task = new MeetingTask(
                        result.getString("Name"),
                        result.getDate("DueDate"),
                        BaseTask.Priority.valueOf(result.getString("Priority")),
                        result.getDate("StartingTime"));

                task.setId(result.getInt("Id"));
                meetings.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return meetings;
    }

    public boolean FindMeetingByName(String name)
    {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from meetingtasks WHERE Name = ?");

            statement.setString(1,name);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
               return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public MeetingTask AddMeetingToCategory(MeetingTask task, BusinessCategory category)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories where Name = ?");
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  meetingtasks SET CategoryId = ? WHERE Name = ?");

            while (resultSet.next())
            {
                statement1.setInt(1, resultSet.getInt("Id"));
            }
            statement1.setString(2, task.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return task;
    }

    public MeetingTask CancelMeetingFromCategory(MeetingTask task, BusinessCategory category)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories where Name = ?");
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  meetingtasks SET CategoryId = null WHERE Name = ?");

            statement1.setString(1, task.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return task;
    }

}
