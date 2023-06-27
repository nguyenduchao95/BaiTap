package QLKP.family;

import QLKP.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private List<Person> family;

    public Family() {
        this.family = new ArrayList<>();
    }

    public List<Person> getFamily() {
        return family;
    }

    public void setFamily(List<Person> family) {
        this.family = family;
    }

    public void addPerson(Person person) {
        family.add(person);
    }

    public void removePerson(int id){
        int index = findIndexById(id);
        if(index != -1){
            family.remove(index);
        }
    }

    private int findIndexById(int id) {
        for (int i = 0; i < family.size(); i++) {
            if (family.get(i).getId() == id) return i;
        }
        return -1;
    }

    public void showAll(){
        for (Person person : family){
            System.out.println(person);
        }
    }
}
