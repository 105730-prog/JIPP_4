package org.example;

import org.example.DAL.Library;
import org.example.DAL.models.Author;
import org.example.DAL.models.Book;
import org.example.menu.Menu;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Menu menu = new Menu(scanner, library);

        while (true) {

            int optionsCount = menu.getState().showOptions();
            int option = menu.getState().readOptions(optionsCount);
            if(option == -1) return;

        }

    }
}