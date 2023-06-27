package QLCB.manage;

import QLCB.person.Person;

public interface IManagePerson {
    void addPerson(Person person);
    void findPersonByName(String name);
    void showAll();
}
