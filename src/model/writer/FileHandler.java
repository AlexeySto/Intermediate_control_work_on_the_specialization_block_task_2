package model.writer;

import model.toys.Toy;

import java.io.*;

public class FileHandler implements Writable{
    @Override
    public boolean save(Object object, String pathFile) {
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(pathFile));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Object load(String pathFile) {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(pathFile));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveToy(Toy toy) {
        try(FileWriter writer = new FileWriter("src/files/wonToys.txt", true)) {
            writer.write(toy.getId() + " " + toy.getName() + "\n");
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
}
