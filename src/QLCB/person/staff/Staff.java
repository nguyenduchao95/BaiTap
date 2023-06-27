package QLCB.person.staff;

import QLCB.person.Person;

public class Staff extends Person {
    private String task;

    public Staff(String task) {
        this.task = task;
    }

    public Staff(String fullName, int age, String gender, String address, String task) {
        super(fullName, age, gender, address);
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Staff {" +
                super.toString() +
                "task='" + task + '\'' +
                '}';
    }
}
