package QLHS.menu;

import QLHS.manager.StudentManagement;
import QLHS.student.Student;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private StudentManagement studentManagement = new StudentManagement();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("============QUẢN LÝ HỌC SINH============");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Sửa học sinh");
            System.out.println("3. Xoá học sinh");
            System.out.println("4. Tìm kiếm học sinh theo tên");
            System.out.println("5. Hiển thị tất cả học sinh");
            System.out.println("0. Thoát");
            int choice;
            while (true) {
                try {
                    System.out.println("Nhập lựa chọn của bạn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 5) throw new Exception();
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số!");
                } catch (Exception e) {
                    System.err.println("Nhập sai lựa chọn!");
                }
            }

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    editMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    showAllMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            String enter;
            do {
                System.out.println("Nhập 'Enter' để tiếp tục");
                enter = scanner.nextLine();
            } while (!enter.equals(""));
        }
    }

    public void addMenu() {
        System.out.println("------Thêm học sinh------");
        int id, age;
        while (true) {
            try {
                System.out.println("Nhập id: ");
                id = Integer.parseInt(scanner.nextLine());
                int index = studentManagement.findIndexById(id);
                if (index != -1) throw new Exception();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng!");
            } catch (Exception e) {
                System.err.println("Id đã tồn tại!");
            }
        }
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Nhập tuổi: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) throw new Exception();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng!");
            } catch (Exception e) {
                System.err.println("Nhập sai tuổi!");
            }
        }

        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        Student student = new Student(id, name, age, address);
        if (studentManagement.addStudent(student)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public void editMenu() {
        System.out.println("------Sửa học sinh------");
        int id;
        while (true) {
            try {
                System.out.println("Nhập id cần sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng!");
            }
        }
        int index = studentManagement.findIndexById(id);
        if (index == -1) System.out.println("Học sinh không tồn tại!");
        else {
            System.out.println("Nhập tên: ");
            String name = scanner.nextLine();
            int age;
            while (true) {
                try {
                    System.out.println("Nhập tuổi: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhập sai định dạng!");
                }
            }

            System.out.println("Nhập địa chỉ: ");
            String address = scanner.nextLine();
            Student student = new Student(id, name, age, address);
            studentManagement.editStudent(id, student);
            System.out.println("Success!");
        }
    }

    public void deleteMenu() {
        System.out.println("------Xóa học sinh------");
        int id;
        while (true) {
            try {
                System.out.println("Nhập id: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng!");
            }
        }

        if (studentManagement.deleteStudent(id)) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public void searchMenu() {
        System.out.println("------Tìm kiếm học sinh theo tên------");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        List<Student> list = studentManagement.findStudentByName(name);
        if (list.size() == 0) System.out.println("Không tìm thấy học sinh");
        else {
            for (Student student : list)
                System.out.println(student);
        }
    }

    public void showAllMenu() {
        System.out.println("------Hiển thị tất cả học sinh------");
        List<Student> list = studentManagement.getAllStudents();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (Student student : list)
                System.out.println(student);
        }
    }
}
