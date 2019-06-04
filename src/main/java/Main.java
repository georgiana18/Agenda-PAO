import models.category.BaseCategory;
import models.category.BusinessCategory;
import models.task.BaseTask;
import models.task.MeetingTask;
import models.task.PaymentTask;
import models.util.Invoice;
import models.util.Person;
import models.util.Project;
import services.CategoryService;
import services.Reader.BusinessCategoryReader;
import services.Reader.MeetingTaskReader;
import services.Reader.PersonReader;
import services.Reader.ProjectReader;
import services.TaskService;
import services.databaseServices.BusinessCategoryService;
import services.databaseServices.MeetingTaskService;
import services.databaseServices.PersonService;
import services.databaseServices.ProjectService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BaseCategory businessCategory = new BusinessCategory("Businees","Tasks for work");
        MeetingTask task1 = new MeetingTask("meeting1", new Date(), BaseTask.Priority.CRITICAL, new Date());
        BaseTask task2 = new MeetingTask("meeting2", new Date(), BaseTask.Priority.LOW, new Date());
        BaseTask task3 = new MeetingTask("meeting3", new Date(), BaseTask.Priority.HIGH, new Date());

        Person person = new Person(56, "Popescu", "management");

        TaskService taskService = new TaskService();

        taskService.AddPersonToMeeting(task1, person);
        CategoryService categoryService = new CategoryService();
        System.out.println(task1.getAttendees().size());

        System.out.println(
                taskService.FindPersonFromMeeting(task1, "Pop"));

        taskService.RemovePersonFromMeeting(task1, person);
        System.out.println(task1.getAttendees().size());

        PaymentTask task4 = new PaymentTask( "payment1", new Date(), BaseTask.Priority.HIGH);
        Invoice invoice = new Invoice("Customer1", 78393.00, "198419941","Energy");
        taskService.AddNewInvoice(task4, invoice);

        System.out.println(task4.getInvoices().size() );

        taskService.RemoveInvoice(task4, "198419941");

        System.out.println(task4.getInvoices().size() );



        businessCategory = categoryService.addMeeting(businessCategory, task1);
        businessCategory = categoryService.addMeeting(businessCategory, task2);
        businessCategory = categoryService.addMeeting(businessCategory, task3);

        businessCategory = categoryService.sortTasks(businessCategory);

        businessCategory = categoryService.removeMeeting(businessCategory, task1);

        System.out.println(businessCategory.getTasks().size());

        businessCategory = categoryService.emptySchedule(businessCategory, new Date());

        /////////////////////////////////////////////////////////////////////////////////////

        PersonReader.main(args);
        List<Person> persons = PersonReader.getPersonList();

        ProjectReader.main(args);
        List<Project> projects = ProjectReader.getProjectList();

        MeetingTaskReader.main(args);
        List<MeetingTask> meetingTasks = new ArrayList<MeetingTask>();
        meetingTasks = MeetingTaskReader.getMeetingTaskList();

        BusinessCategoryReader.main(args);
        List<BusinessCategory> businessCategories = new ArrayList<BusinessCategory>();
        businessCategories = BusinessCategoryReader.getBusinessCategoryList();

        ////////////////////////////////////////////////////////////////////////////////////////

        PersonService personService = new PersonService();

        BusinessCategoryService businessCategoryService = new BusinessCategoryService();

        MeetingTaskService meetingTaskService = new MeetingTaskService();

        ProjectService projectService = new ProjectService();

       for (BusinessCategory category: businessCategories)
        {
            businessCategoryService.saveCategory(category);
        }

        for(MeetingTask meetingTask: meetingTasks)
        {
            meetingTaskService.saveMeeting(meetingTask);
        }

        for(Project p: projects)
        {
            projectService.saveProject(p);
        }

        for (Person p: persons) {
            personService.savePerson(p);
        }

        projectService.deleteProject(projects.get(1));
        personService.deletePerson(persons.get(0));
        meetingTaskService.deleteMeeting(meetingTasks.get(1));
        businessCategoryService.deleteCategory(businessCategories.get(1));

        List<BusinessCategory> db_categories = businessCategoryService.getAll();
        System.out.println(db_categories.size());

       List<Project> db_projects = projectService.getAll();
       System.out.println(db_projects.size());

        List<Person> db_persons = personService.getAll();
        System.out.println(db_persons.size());

        List<MeetingTask> db_meetings = meetingTaskService.getAll();
        System.out.println(db_meetings.size());

        personService.AddPersonToMeeting(persons.get(1),meetingTasks.get(0));
       // personService.RemovePersonFromMeeting(persons.get(1),meetingTasks.get(0));

        projectService.AddProjectToCategory(projects.get(0), businessCategories.get(2));
        meetingTaskService.AddMeetingToCategory(meetingTasks.get(0), businessCategories.get(0));
    }
}
