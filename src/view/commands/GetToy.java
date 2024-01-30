package view.commands;

import view.ConsoleUI;

public class GetToy extends Command{
    public GetToy(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Произвести розыгрыш случайной игрушки.";
    }

    public void execute(){
        consoleUI.getToy();
    }
}
