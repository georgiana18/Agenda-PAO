package models.util;

public class Person {
    private int id;
    private  int age;
    private String name;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person ()
    {

    }

    public Person(int age, String name, String department)  {
        this.age = age;
        this.name = name;
        this.department = department;
    }
}
