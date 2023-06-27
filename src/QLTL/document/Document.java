package QLTL.document;

import QLTL.book.Book;
import QLTL.magazine.Magazine;
import QLTL.newspaper.Newspaper;

public class Document {
    private static int countBook;
    private static int countMagazine;
    private static int countNewspaper;
    private String id;
    private String publisher;
    private int quantity;

    public Document(String publisher, int quantity) {
        if(this instanceof Book) this.id = "Book-" + ++countBook;
        if(this instanceof Magazine) this.id = "Magazine-" + ++countMagazine;
        if(this instanceof Newspaper) this.id = "Newspaper-" + ++countNewspaper;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                " ";
    }
}
