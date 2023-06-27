package QLTL.magazine;

import QLTL.document.Document;

public class Magazine extends Document {
    private int vol;
    private int month;

    public Magazine(String publisher, int quantity, int vol, int month) {
        super(publisher, quantity);
        this.vol = vol;
        this.month = month;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Magazine {" +
                super.toString() +
                "vol=" + vol +
                ", month=" + month +
                '}';
    }
}
