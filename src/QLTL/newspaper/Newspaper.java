package QLTL.newspaper;

import QLTL.document.Document;

public class Newspaper extends Document {
    private int day;

    public Newspaper(String publisher, int quantity, int day) {
        super(publisher, quantity);
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Newspaper {" +
                super.toString() +
                "day=" + day +
                '}';
    }
}
