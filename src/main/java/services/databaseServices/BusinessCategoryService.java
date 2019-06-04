package services.databaseServices;

import models.category.BusinessCategory;
import repositories.BusinessCategoryRepository;

import java.util.List;

public class BusinessCategoryService {
    private static BusinessCategoryRepository repository = new BusinessCategoryRepository();

    public void saveCategory(BusinessCategory category){
        if(repository.FindCategoryByName(category.getName())) {
            System.out.println("Exista deja o categorie cu acest nume");
            return;
        }

        repository.saveBusinessCategory(category);
        System.out.println("Saved category!");

    }

    public void deleteCategory(BusinessCategory category){
        repository.deleteCategory(category);
        System.out.println("Deleted category");
    }

    public List<BusinessCategory> getAll()
    {
        List<BusinessCategory> categories = repository.getAll();
        System.out.println("Get all categories");
        return categories;
    }

}
