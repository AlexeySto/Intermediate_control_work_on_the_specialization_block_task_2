package view.commands;

import view.ConsoleUI;

public class AddToys extends Command{
    public AddToys(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушки для розыгрыша.";
    }

    public void execute(){
        consoleUI.addToys();
    }
}
