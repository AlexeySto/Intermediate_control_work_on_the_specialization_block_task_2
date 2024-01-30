package model.toys;

import java.io.Serializable;
import java.util.*;

public class SetToys implements Serializable {
    private List<Toy> toysList;
    private final Deque<Toy> wonToysQueue;
    public SetToys() {
        toysList = new ArrayList<>();
        wonToysQueue = new ArrayDeque<>();
    }

    public boolean addToy(Toy toy) {
        return toysList.add(toy);
    }
    public String getToy() {
        int allWeight = 1;
        for (Toy toy : toysList) {
            allWeight += toy.getWeight();
        }
        Random random = new Random();
        int wonVal = random.nextInt(allWeight);
        int val = 0;
        for (Toy toy : toysList) {
            val += toy.getWeight();
            if (val >= wonVal) {
                wonToysQueue.add(toy);
                toysList.remove(toy);
                return toy.getName();
            }
        }
        return "Игрушки нет.(";
    }
    public Toy giveToy() {
        return wonToysQueue.pollFirst();
    }

    public String allToysInShop() {
        return getInfo(toysList);
    }
    public String allToysInQueue() {
        return getInfo(wonToysQueue);
    }

    private String getInfo(Collection<Toy> collection) {
        StringBuilder res = new StringBuilder();
        for (Toy toy : collection) {
            res.append(toy.toString()).append("\n");
        }
        return res.toString();
    }
}
