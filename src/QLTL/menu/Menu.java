package QLTL.menu;


import QLTL.book.Book;
import QLTL.magazine.Magazine;
import QLTL.manage.ManageDocument;
import QLTL.newspaper.Newspaper;

import java.util.Scanner;

public class Menu {
    private Scanner scannerString;
    private Scanner scannerNumber;
    private ManageDocument manageDocument;

    public Menu() {
        this.scannerString = new Scanner(System.in);
        this.scannerNumber = new Scanner(System.in);
        this.manageDocument = new ManageDocument();
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("-----------MENU-----------");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xóa tài liệu theo mã tài liệu");
            System.out.println("3. Hiển thị tất cả thông tin về tài liệu");
            System.out.println("4. Hiển thị tất cả Sách");
            System.out.println("5. Hiển thị tất cả Tạp chí");
            System.out.println("6. Hiển thị tất cả Báo");
            System.out.println("0. Thoát khỏi chương trình");
            choice = scannerNumber.nextInt();
            if (choice == 1) {
                menuAdd();
            } else if (choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6) {
                if (choice == 2) {
                    System.out.println("Nhập mã tài liệu muốn xóa: ");
                    String id = scannerString.nextLine();
                    manageDocument.deleteById(id);
                } else if (choice == 3) {
                    manageDocument.showAll();
                } else if (choice == 4) {
                    manageDocument.showAllByType("Book");
                } else if (choice == 5) {
                    manageDocument.showAllByType("Magazine");
                } else {
                    manageDocument.showAllByType("Newspaper");
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
            System.out.println("-----------THÊM MỚI TÀI LIỆU-----------");
            System.out.println("1. Thêm sách");
            System.out.println("2. Thêm tạp chí");
            System.out.println("3. Thêm báo");
            System.out.println("0. Thoát");
            choice = scannerNumber.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println("Nhập tên nhà xuất bản: ");
                String publisher = scannerString.nextLine();
                System.out.println("Nhập số bản phát hành: ");
                int quantity = scannerNumber.nextInt();

                if (choice == 1) {
                    System.out.println("Nhập tên tác giả: ");
                    String author = scannerString.nextLine();
                    System.out.println("Nhập số trang: ");
                    int page = scannerNumber.nextInt();
                    Book book = new Book(publisher, quantity, author, page);
                    manageDocument.addDocument(book);
                } else if (choice == 2) {
                    System.out.println("Nhập số phát hành: ");
                    int vol = scannerNumber.nextInt();
                    System.out.println("Nhập tháng phát hành: ");
                    int month = scannerNumber.nextInt();
                    Magazine magazine = new Magazine(publisher, quantity, vol, month);
                    manageDocument.addDocument(magazine);
                } else {
                    System.out.println("Nhập ngày phát hành: ");
                    int day = scannerNumber.nextInt();
                    Newspaper newspaper = new Newspaper(publisher, quantity, day);
                    manageDocument.addDocument(newspaper);
                }
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Lựa chọn không đúng!");
            }
        } while (choice != 0);
    }

}
