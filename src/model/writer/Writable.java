package model.writer;

public interface Writable {
    boolean save(Object object, String pathFile);
    Object load(String pathFile);
}
