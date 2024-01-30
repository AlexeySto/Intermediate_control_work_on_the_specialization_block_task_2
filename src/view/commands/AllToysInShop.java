package view.commands;

import view.ConsoleUI;

public class AllToysInShop extends Command{
    public AllToysInShop(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Список всех игрушек в магазине.";
    }

    public void execute(){
        consoleUI.allToysInShop();
    }
}
