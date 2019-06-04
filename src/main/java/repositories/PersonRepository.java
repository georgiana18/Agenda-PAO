package repositories;

import connectivity.DatabaseConnection;
import models.task.MeetingTask;
import models.util.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private DatabaseConnection connection =
            DatabaseConnection.getInstance();

    public void savePerson(Person person) {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO persons VALUES (NULL,?,?,?,?)");

            statement.setInt(1, person.getAge());
            statement.setString(2, person.getName());
            statement.setString(3, person.getDepartment());
            statement.setString(4,null);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(Person person)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("DELETE from persons WHERE Name = ? ");
            statement.setString(1,person.getName());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Person> getAll()
    {
        List<Person> persons = new ArrayList<>();
        try {

            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from persons");
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                Person person = new Person(result.getInt("Age"),
                                           result.getString("Name"),
                                           result.getString("Department"));
                person.setId(result.getInt("Id"));
                persons.add(person);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return persons;
    }

    public boolean FindPersonByName(String name)
    {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from persons WHERE Name = ?");

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

    public Person AddPersonToMeeting(Person person, MeetingTask meeting)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from meetingtasks where Name = ?");
            statement.setString(1, meeting.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  persons SET MeetingId = ? WHERE Name = ?");

            while (resultSet.next())
            {
                statement1.setInt(1, resultSet.getInt("Id"));
            }
            statement1.setString(2, person.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return person;
    }


    public Person RemovePersonFromMeeting(Person person, MeetingTask meeting)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from meetingtasks where Name = ?");
            statement.setString(1, meeting.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  persons SET MeetingId = null WHERE Name = ?");

            statement1.setString(1, person.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return person;
    }
}
