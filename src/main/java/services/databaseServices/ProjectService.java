package services.databaseServices;

import models.category.BusinessCategory;
import models.util.Project;
import repositories.ProjectRepository;

import java.util.List;

public class ProjectService {
    private static ProjectRepository repository = new ProjectRepository();

    public void saveProject(Project project){
        if(repository.FindProjectByName(project.getName()))
        {
            System.out.println("There is already a project with that name in db");
            return;
        }
        repository.saveProject(project);
        System.out.println("Saved project!");
    }

    public void deleteProject(Project project){
        repository.deleteProject(project);
        System.out.println("Deleted project");
    }

    public List<Project> getAll()
    {
        List<Project> projects = repository.getAll();
        System.out.println("Got all projects!");
        return  projects;
    }


    public Project AddProjectToCategory(Project project, BusinessCategory category)
    {
        Project updatedProject = repository.AddProjectToCategory(project, category);
        System.out.println("Added project "+ project.getName() +" in category "+ category.getName());
        return updatedProject;
    }

    public Project RemoveProjectFromCategory(Project project, BusinessCategory category)
    {
        Project updatedProject = repository.RemoveProjectFormCategory(project, category);
        System.out.println("Removed project "+ project.getName() +" from category "+ category.getName());
        return updatedProject;
    }

}
