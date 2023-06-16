package org.example.menu;

import org.example.DAL.models.Author;
import org.example.DAL.models.Book;

import java.util.List;
import java.util.Scanner;

public class UserBookSearchMenu extends MenuState{

    public UserBookSearchMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {
        System.out.println();
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Search by genre");
        System.out.println("0. Back");

        return 4;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> this.menu.findBooksByTitle();
            case 2 -> this.menu.findBooksByAuthor();
            case 3 -> this.menu.findBooksByGenre();
            case 0 -> this.menu.changeState(new UserMenu(this.menu, this.scanner));
        }

        return 0;
    }

}
