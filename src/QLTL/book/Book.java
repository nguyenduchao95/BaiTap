package QLTL.book;

import QLTL.document.Document;

public class Book extends Document {
    private String author;
    private int page;

    public Book(String publisher, int quantity, String author, int page) {
        super(publisher, quantity);
        this.author = author;
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book {" +
                super.toString() +
                "author='" + author + '\'' +
                ", page=" + page +
                '}';
    }
}
