package services.Reader;

import models.category.BusinessCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessCategoryReader extends Reader<BusinessCategory> {
    private static List<BusinessCategory> businessCategoryList = new ArrayList<BusinessCategory>();

    public static void main(String args[]) {

        BusinessCategoryReader businessCategoryReader = new BusinessCategoryReader();

        businessCategoryList = businessCategoryReader.readObjects(
                "src/main/resources/businessCategory.csv");

        for (BusinessCategory category : businessCategoryList ) {
            System.out.println(category.getName());
        }
    }

    public static List<BusinessCategory> getBusinessCategoryList() {
        return Collections.unmodifiableList(businessCategoryList);
    }

    @Override
    BusinessCategory createObject(String[] objectDetails) {

        BusinessCategory businessCategory = new BusinessCategory(objectDetails[0],objectDetails[1]) ;

        return businessCategory;
    }
}

