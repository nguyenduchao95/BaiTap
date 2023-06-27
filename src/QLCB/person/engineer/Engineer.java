package QLCB.person.engineer;

import QLCB.person.Person;

public class Engineer extends Person {
    private String majors;

    public Engineer(String majors) {
        this.majors = majors;
    }

    public Engineer(String fullName, int age, String gender, String address, String majors) {
        super(fullName, age, gender, address);
        this.majors = majors;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    @Override
    public String toString() {
        return "Engineer {" +
                super.toString() +
                "majors='" + majors + '\'' +
                '}';
    }
}
