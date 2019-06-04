package services.databaseServices;

import models.category.BusinessCategory;
import models.task.MeetingTask;
import repositories.MeetingTaskRepository;

import java.util.List;

public class MeetingTaskService {
    private  static MeetingTaskRepository repository = new MeetingTaskRepository();

    public void saveMeeting(MeetingTask meetingTask){

        if(repository.FindMeetingByName(meetingTask.getName()))
        {
            System.out.println("Unavailable name");
            return;
        }
        repository.saveTask(meetingTask);
        System.out.println("Saved meeting!");
    }

    public void deleteMeeting(MeetingTask meetingTask){
        repository.deleteMeeting(meetingTask);
        System.out.println("Deleted meeting");
    }

    public List<MeetingTask> getAll()
    {
        List<MeetingTask> meetings = repository.getAll();
        System.out.println("Get all meetings!");
        return  meetings;
    }

    public MeetingTask AddMeetingToCategory(MeetingTask meeting, BusinessCategory category)
    {
        MeetingTask updatedMeeting = repository.AddMeetingToCategory(meeting, category);
        System.out.println("Added meeting "+ meeting.getName() +" in category "+ category.getName());
        return updatedMeeting;
    }

    public MeetingTask CancelMeetingFromCategory(MeetingTask meeting, BusinessCategory category)
    {
        MeetingTask updatedMeeting = repository.CancelMeetingFromCategory(meeting, category);
        System.out.println("Removed meeting "+ meeting.getName() +" in category "+ category.getName());
        return updatedMeeting;
    }

}
