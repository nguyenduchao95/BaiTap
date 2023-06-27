package QLCB.manage;

import QLCB.person.Person;

import java.util.Arrays;

public class ManagePerson implements IManagePerson {
    private Person[] persons;

    public ManagePerson() {
        this.persons = new Person[0];
    }

    public ManagePerson(Person[] persons) {
        this.persons = persons;
    }

    @Override
    public void addPerson(Person person) {
        this.persons = Arrays.copyOf(this.persons, this.persons.length + 1);
        this.persons[this.persons.length - 1] = person;
    }

    @Override
    public void findPersonByName(String name) {
        boolean isCheck = false;
        for (Person person : this.persons) {
            if(person.getFullName().contains(name)){
                System.out.println(person);
                isCheck = true;
            }
        }
        if(!isCheck) System.out.println("Không tìm thấy cán bộ");
    }

    @Override
    public void showAll() {
        for (Person person : this.persons) {
                System.out.println(person);
        }
    }
}
