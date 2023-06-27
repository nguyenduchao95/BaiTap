package QLCB.menu;

import QLCB.manage.ManagePerson;
import QLCB.person.employee.Employee;
import QLCB.person.engineer.Engineer;
import QLCB.person.staff.Staff;

import java.util.Scanner;

public class Menu {
    private Scanner scannerString;
    private Scanner scannerNumber;
    private ManagePerson managePerson;

    public Menu() {
        this.scannerString = new Scanner(System.in);
        this.scannerNumber = new Scanner(System.in);
        this.managePerson = new ManagePerson();
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("-----------MENU-----------");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị thông tin về danh sách các cán bộ");
            System.out.println("0. Thoát khỏi chương trình");
            choice = scannerNumber.nextInt();
            if (choice == 1) {
                menuAdd();
            } else if (choice == 2 || choice == 3) {
                if (choice == 2) {
                    System.out.println("Nhập họ tên tìm kiếm: ");
                    String fullName = scannerString.nextLine();
                    managePerson.findPersonByName(fullName);
                } else {
                    managePerson.showAll();
                }

                String enter;
                do {
                    System.out.println("Nhấn 'Enter' để tiếp tục");
                    enter = scannerString.nextLine();
                } while (!enter.equals(""));
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Lựa chọn không đúng!");
            }
        } while (choice != 0);
    }

    private void menuAdd() {
        int choice;
        do {
            System.out.println("-----------THÊM MỚI CÁN BỘ-----------");
            System.out.println("1. Thêm công nhân");
            System.out.println("2. Thêm kỹ sư");
            System.out.println("3. Thêm nhân viên");
            System.out.println("0. Thoát");
            choice = scannerNumber.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println("Nhập họ tên: ");
                String fullName = scannerString.nextLine();
                System.out.println("Nhập tuổi: ");
                int age = scannerNumber.nextInt();
                System.out.println("Nhập giới tính: ");
                String gender = scannerString.nextLine();
                System.out.println("Nhập địa chỉ: ");
                String address = scannerString.nextLine();

                if (choice == 1) {
                    System.out.println("Nhập bậc: ");
                    byte level = scannerNumber.nextByte();
                    Employee employee = new Employee(fullName, age, gender, address, level);
                    managePerson.addPerson(employee);
                } else if (choice == 2) {
                    System.out.println("Nhập ngành đào tạo: ");
                    String majors = scannerString.nextLine();
                    Engineer engineer = new Engineer(fullName, age, gender, address, majors);
                    managePerson.addPerson(engineer);
                } else {
                    System.out.println("Nhập công việc: ");
                    String task = scannerString.nextLine();
                    Staff staff = new Staff(fullName, age, gender, address, task);
                    managePerson.addPerson(staff);
                }
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Lựa chọn không đúng!");
            }
        } while (choice != 0);
    }

}
