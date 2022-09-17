package ds_04.serialisation;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String place;
    private int year;

    public Person(String aName, String aPlace, int aYear) {
        name = aName;
        place = aPlace;
        year = aYear;
    }

    public void printValues() {
        System.out.println("Name=" + name + ", Place=" + place + ", Year="
                + year);
    }
}
