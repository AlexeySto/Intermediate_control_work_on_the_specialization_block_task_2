package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Введено не корректное значение!";
    private final Scanner scanner;
    private final Presenter presenter;
    private final MainMenu menu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        work = true;
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            executeRequest();
        }

    }

    private void hello() { System.out.println("Здравствуйте!");}
    private void printMenu() {
        System.out.println(menu.getMenu());
    }
    private void executeRequest() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize() + 1){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    @Override
    public void printAnswer(String text) { System.out.println(text);}

    public void addToys() {
        System.out.println("Введите название игрушки:");
        String nameToy = scanner.nextLine();
        System.out.println("Введите вес игрушки:");
        try {
            int weightToy = Integer.parseInt(scanner.nextLine());
            presenter.addToys(nameToy, weightToy);
        } catch (NumberFormatException e) {
            inputError();
        }

    }
    public void getToy() {
        presenter.getToy();
    }
    public void giveToy() {
        presenter.giveToy();
    }
    public void allToysInShop() {
        presenter.allToysInShop();
    }
    public void allToysInQueue() {
        presenter.allToysInQueue();
    }
    public void finish() {
        if (presenter.finish()){
            System.out.println("Файлы успешно сохранены!");
        }
        else {
            System.out.println("Не удалось сохранить файлы!");
        }
        System.out.println("Досвидания!");
        work = false;
    }
}
