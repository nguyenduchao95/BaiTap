package QLCB.person.employee;

import QLCB.person.Person;

public class Employee extends Person {
    private byte level;

    public Employee(byte level) {
        this.level = level;
    }

    public Employee(String fullName, int age, String gender, String address, byte level) {
        super(fullName, age, gender, address);
        this.level = level;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employee {" +
                super.toString() +
                "level=" + level +
                '}';
    }
}
