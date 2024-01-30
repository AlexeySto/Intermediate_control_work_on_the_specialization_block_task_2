package view.commands;

import view.ConsoleUI;

public class GiveToy extends Command{
    public GiveToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выдать игрушку.";
    }

    public void execute(){
        consoleUI.giveToy();
    }
}
