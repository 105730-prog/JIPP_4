package org.example.menu;

import java.util.Scanner;

public class AdminOrdersMenu extends MenuState{

    public AdminOrdersMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {
        System.out.println();
        System.out.println("1. Show all orders");
        System.out.println("2. Cancel order");
        System.out.println("0. Back");
        System.out.println();

        return 3;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> this.menu.printBorrowedBooks(this.menu.library.getAllOrders());
            case 2 -> this.cancelOrder();
            case 0 -> this.menu.changeState(new LibrarianMenu(this.menu, this.scanner));
        }

        return 0;
    }

    private void cancelOrder(){
        this.menu.printBorrowedBooks(this.menu.library.getAllOrders());
        System.out.print("Provide order id: ");
        this.scanner.nextLine();
        int id = this.scanner.nextInt();

        if(this.menu.library.returnBook(id)){
            System.out.println("Order has been canceled successfully");
        }else{
            System.out.println("Order not found");
        }
    }

}
