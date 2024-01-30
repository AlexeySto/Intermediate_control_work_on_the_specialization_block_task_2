package view.commands;

import view.ConsoleUI;

public class AllToysInQueue extends Command{
    public AllToysInQueue(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Список игрушек для выдачи.";
    }

    public void execute(){
        consoleUI.allToysInQueue();
    }
}
