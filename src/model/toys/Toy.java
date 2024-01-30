package model.toys;

import java.io.Serializable;

public class Toy implements Serializable {
    private static int countID;
    private final int id;
    private final String name;
    private final int weight;

    public Toy(String name, int weight) {
        id = ++countID;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }

    public static void setCountID(int countID) {
        Toy.countID = countID;
    }
    public  static int getCountID() {
        return Toy.countID;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight;
    }
}
