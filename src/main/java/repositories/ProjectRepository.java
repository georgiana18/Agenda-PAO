package repositories;

import connectivity.DatabaseConnection;
import models.category.BusinessCategory;
import models.util.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private DatabaseConnection connection =
            DatabaseConnection.getInstance();

    public void saveProject(Project project) {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO projects VALUES (NULL,?,?,?)");

            statement.setString(1, project.getName());
            statement.setDate(2,  new java.sql.Date(project.getDueDate().getTime()));
            statement.setString(3,null);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(Project project)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("DELETE from projects WHERE Name = ? ");
            statement.setString(1,project.getName());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Project> getAll()
    {
        List<Project> projects = new ArrayList<>();
        try {

            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from projects");
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                Project project = new Project(result.getDate("DueDate"),result.getString("Name"));
                project.setId(result.getInt("Id"));
                projects.add(project);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return projects;
    }

    public boolean FindProjectByName(String name)
    {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from projects WHERE Name = ?");

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


    public Project AddProjectToCategory(Project project, BusinessCategory category)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories where Name = ?");
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  projects SET CategoryId = ? WHERE Name = ?");

            while (resultSet.next())
            {
                statement1.setInt(1, resultSet.getInt("Id"));
            }
            statement1.setString(2, project.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return project;
    }

    public Project RemoveProjectFormCategory(Project project, BusinessCategory category)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories where Name = ?");
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();

            PreparedStatement statement1 = connection.getConnection()
                    .prepareStatement("UPDATE  projects SET CategoryId = null WHERE Name = ?");

            statement1.setString(1, project.getName());

            statement1.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return project;
    }





}
