package org.example.menu;

import java.util.Scanner;

public abstract class MenuState {

    Menu menu;
    Scanner scanner;

    public MenuState(Menu menu, Scanner scanner){
        this.menu = menu;
        this.scanner = scanner;
    }

    public abstract int showOptions();
    public abstract int readOptions(int optionsCount);

    public int getValueFromUserInput(int optionsCount) {
        try {
            int option = this.scanner.nextInt();
            if (option < 0 || option >= optionsCount) {
                System.out.println("Incorrect option. Try again.");
                return -1;
            }
            return option;
        } catch (Exception e) {
            System.out.println("Incorrect option. Try again.");
            scanner.nextLine();
            return -1;
        }
    }

}
