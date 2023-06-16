package org.example.menu;

import java.util.Scanner;

public class LibrarianMenu extends MenuState{

    public LibrarianMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {
        System.out.println();
        System.out.println("1. Library");
        System.out.println("2. Borrowed books");
        System.out.println("0. Sign out");
        System.out.println();

        return 3;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> {
                this.menu.changeState(new AdminLibraryMenu(this.menu, this.scanner));
            }
            case 2 -> {
                this.menu.changeState(new AdminOrdersMenu(this.menu, this.scanner));
            }
            case 0 -> {
                this.menu.changeState(new StartupMenu(this.menu, this.scanner));
            }
        }

        return 0;
    }

}
