import java.io.*;

public class Person implements Serializable {
    private String name;
    private String place;
    private int year;

    public Person(String name, String place, int year) {
        this.name = name;
        this.place = place;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.place + ", " + this.year;
    }
}
