package repositories;

import connectivity.DatabaseConnection;
import models.category.BaseCategory;
import models.category.BusinessCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessCategoryRepository {
    private DatabaseConnection connection =
            DatabaseConnection.getInstance();

    public void saveBusinessCategory(BusinessCategory category) {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO businesscategories VALUES (NULL,?,?)");

            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCategory(BusinessCategory category)
    {
        try{
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("DELETE from businesscategories WHERE Name = ? ");
            statement.setString(1,category.getName());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<BusinessCategory> getAll()
    {
        List<BusinessCategory> categories = new ArrayList<>();
        try {

            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories");
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                BusinessCategory category = new BusinessCategory();
                category.setId(result.getInt("Id"));
                category.setName(result.getString("Name"));
                category.setDescription(result.getString("Description"));
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return categories;
    }

    public boolean FindCategoryByName(String name)
    {
        try {
            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("SELECT * from businesscategories WHERE Name = ?");

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
}
