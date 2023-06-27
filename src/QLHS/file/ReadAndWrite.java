package QLHS.file;

import QLHS.student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private File data = new File("src/QLHS/data/students.csv");

    public List<Student> readData() {
        List<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(data);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                list.add(new Student(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]), strings[3]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeData(List<Student> list) {
        try {
            FileWriter fileWriter = new FileWriter(data);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student st : list) {
                bufferedWriter.write(st.writeString());
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
