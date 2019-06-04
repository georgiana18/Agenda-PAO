package services.databaseServices;

import models.task.MeetingTask;
import models.util.Person;
import repositories.PersonRepository;

import java.util.List;

public class PersonService {
    private static PersonRepository personRepository = new PersonRepository();

    public void savePerson(Person person){

        if(personRepository.FindPersonByName(person.getName()))
        {
            System.out.println("This Person is already in database");
            return;
        }
        personRepository.savePerson(person);
        System.out.println("Saved person!");
    }

    public void deletePerson(Person person){
        personRepository.deletePerson(person);
        System.out.println("Deleted person");
    }

    public List<Person> getAll()
    {
        List<Person> persons = personRepository.getAll();
        System.out.println("Get all persons!");
        return  persons;
    }
    public Person AddPersonToMeeting(Person person, MeetingTask meeting)
    {
        Person updatedPerson = personRepository.AddPersonToMeeting(person, meeting);
        System.out.println("Added person "+ person.getName() +" in meeting "+ meeting.getName());
        return updatedPerson;
    }

    public Person RemovePersonFromMeeting(Person person, MeetingTask meeting) {
        Person updatedPerson = personRepository.RemovePersonFromMeeting(person, meeting);
        System.out.println("Removed person " + person.getName() + " in meeting " + meeting.getName());
        return updatedPerson;
    }

}
