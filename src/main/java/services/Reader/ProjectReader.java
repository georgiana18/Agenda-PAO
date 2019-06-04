package services.Reader;

import models.util.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ProjectReader extends Reader<Project> {
    private static List<Project> projectList = new ArrayList<Project>();

    public static void main(String args[]) {

        ProjectReader projectReader = new ProjectReader();

        projectList = projectReader.readObjects(
                "src/main/resources/project.csv");

        for (Project project : projectList) {
            System.out.println(project.getName());
        }
    }

    public static List<Project> getProjectList() {
        return Collections.unmodifiableList(projectList);
    }

    @Override
    Project createObject(String[] objectDetails) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {

            String dateInString = objectDetails[1];
            Date date = formatter.parse(dateInString);
            Project project = new Project(date, objectDetails[0]);
            return project;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
