package models.category;

import models.util.Project;

import java.util.Set;

public class BusinessCategory extends BaseCategory {

    private Set<Project> openProjects;

    public Set<Project> getOpenProjects() {
        return openProjects;
    }

    public void setOpenProjects(Set<Project> openProjects) {
        this.openProjects = openProjects;
    }

    public BusinessCategory()
    {

    }

    public BusinessCategory(String name, String description) {
        super(name, description);
    }
}
