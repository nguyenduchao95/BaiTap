package QLHS.manager;

import QLHS.file.ReadAndWrite;
import QLHS.student.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private ReadAndWrite readAndWrite = new ReadAndWrite();
    private List<Student> studentList = readAndWrite.readData();

    public StudentManagement() {
    }

    public boolean addStudent(Student student) {
        if (studentList.add(student)) {
            readAndWrite.writeData(studentList);
            return true;
        } else return false;

    }

    public void editStudent(int id, Student student) {
        int index = findIndexById(id);
        studentList.set(index, student);
        readAndWrite.writeData(studentList);
    }

    public boolean deleteStudent(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            studentList.remove(index);
            readAndWrite.writeData(studentList);
            return true;
        }
        return false;
    }

    public List<Student> findStudentByName(String name) {
        List<Student> list = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase()))
                list.add(student);
        }
        return list;
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) return i;
        }
        return -1;
    }
}
