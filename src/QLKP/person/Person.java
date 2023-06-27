package QLKP.person;

public class Person {
    private String fullName;
    private int age;
    private String job;
    private int id;
    private static int countId;

    public Person(String fullName, int age, String job) {
        this.fullName = fullName;
        this.age = age;
        this.job = job;
        this.id = ++countId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        Person.countId = countId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", id=" + id +
                '}';
    }
}
