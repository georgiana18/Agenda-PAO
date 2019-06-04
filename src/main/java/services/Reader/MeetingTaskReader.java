package services.Reader;

import models.task.BaseTask;
import models.task.MeetingTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MeetingTaskReader extends Reader<MeetingTask> {
    private static List<MeetingTask> meetingTaskList = new ArrayList<MeetingTask>();

    public static void main(String args[]) {

        MeetingTaskReader meetingTaskReader = new MeetingTaskReader();

        meetingTaskList = meetingTaskReader.readObjects(
                "src/main/resources/meetingTask.csv");

        for (MeetingTask meetingTask : meetingTaskList) {
            System.out.println(meetingTask.getName());
        }
    }

    public static List<MeetingTask> getMeetingTaskList() {
        return Collections.unmodifiableList(meetingTaskList);
    }

    @Override
    MeetingTask createObject(String[] objectDetails) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {

            String dateInString = objectDetails[1];
            Date date = formatter.parse(dateInString);
            MeetingTask meetingTask = new MeetingTask(objectDetails[0], date, BaseTask.Priority.valueOf(objectDetails[2]), formatter.parse(objectDetails[3])) ;
            return meetingTask;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }
}