package QLKP.town;

import QLKP.family.Family;

import java.util.List;

public class Town {
    private static int countIdFamily;
    private int idFamily;
    private List<Family> town;

    public Town(List<Family> town) {
        this.idFamily = ++countIdFamily;
        this.town = town;
    }

    public static int getCountIdFamily() {
        return countIdFamily;
    }

    public static void setCountIdFamily(int countIdFamily) {
        Town.countIdFamily = countIdFamily;
    }

    public int getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
    }

    public List<Family> getTown() {
        return town;
    }

    public void setTown(List<Family> town) {
        this.town = town;
    }
}
