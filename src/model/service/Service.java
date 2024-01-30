package model.service;

import model.toys.SetToys;
import model.toys.Toy;
import model.writer.FileHandler;

public class Service {
    private final String PATH_SET_TOYS_FILE = "src/files/setToys.out";
    private final String PATH_COUNT_ID_FILE = "src/files/countId.out";

    private SetToys setToys;
    private FileHandler fileHandler;

    public Service() {
        fileHandler = new FileHandler();
        try {
            setToys = (SetToys) fileHandler.load(PATH_SET_TOYS_FILE);
        } catch (Exception e) {
            setToys = new SetToys();
        }
        try {
            Toy.setCountID((int) fileHandler.load(PATH_COUNT_ID_FILE));
        } catch (Exception e) {
            Toy.setCountID(0);
        }

    }
    public String addToys(String nameToy, int weightToy) {
        if (setToys.addToy(new Toy(nameToy, weightToy))) {
            return "Игрушка добавлена!";
        }
        else {
            return "Не удалось добавить игрушку!";
        }
    }
    public String getToy() {
        return setToys.getToy();
    }
    public String giveToy() {
        Toy toy = setToys.giveToy();
        if (toy != null) {
            fileHandler.saveToy(toy);
            return "Игрушка " +toy.getName() + " выдана!";
        }
        return "Игрушек для выдачи больше нет.(";
    }
    public boolean finish() {
        return (fileHandler.save(setToys, PATH_SET_TOYS_FILE) && fileHandler.save(Toy.getCountID(), PATH_COUNT_ID_FILE));
    }

    public String allToysInShop() {
        return setToys.allToysInShop();
    }
    public String allToysInQueue() {
        return setToys.allToysInQueue();
    }
}
