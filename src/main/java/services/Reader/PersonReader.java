package services.Reader;

import models.util.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonReader extends Reader<Person> {
    private static List<Person> personList = new ArrayList<Person>();

    public static void main(String args[]) {

        PersonReader personReader = new PersonReader();

        personList = personReader.readObjects(
                "src/main/resources/person.csv");

        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }

    public static List<Person> getPersonList() {
        return Collections.unmodifiableList(personList);
    }

    @Override
    Person createObject(String[] objectDetails) {

        Person person = new Person( Integer.valueOf(objectDetails[0]),  objectDetails[1], objectDetails[2]) ;

        return person;
    }
}
