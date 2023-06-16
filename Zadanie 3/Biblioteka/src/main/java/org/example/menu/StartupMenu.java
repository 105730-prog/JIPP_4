package org.example.menu;

import org.example.DAL.models.User;

import java.util.Scanner;

public class StartupMenu extends MenuState{

    public StartupMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {
        System.out.println();
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("0. Exit");
        System.out.println();

        return 3;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> {
                signIn();
            }
            case 2 -> {
                signUp();
            }
            case 0 -> {
                return -1;
            }
        }

        return 0;
    }

    private void signIn(){
        System.out.print("Login: ");
        scanner.nextLine();
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        User user = this.menu.library.findUserByLogin(login);
        if(user == null || !user.getPassword().equalsIgnoreCase(password)){
            System.out.println("Incorrect login or password");
            return;
        }

        proceedLogIn(user);
    }

    private void signUp(){

        System.out.print("Login: ");
        scanner.nextLine();
        String login = scanner.nextLine();
        User user = this.menu.library.findUserByLogin(login);
        if(user != null){
            System.out.println("User with provided login already exists");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        this.menu.library.addUser(login, password, name, surname);
        user = this.menu.library.findUserByLogin(login);
        proceedLogIn(user);
    }

    private void proceedLogIn(User user){
        this.menu.library.setActualUser(user);
        if(user.getRole().equalsIgnoreCase("librarian")){
            this.menu.changeState(new LibrarianMenu(this.menu, this.scanner));
        }else{
            this.menu.changeState(new UserMenu(this.menu, this.scanner));
        }
    }
}
