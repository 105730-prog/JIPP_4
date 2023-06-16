package org.example.menu;

import java.util.Scanner;

public class UserMenu extends MenuState {

    public UserMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {
        System.out.println();
        System.out.println("1. Show all books");
        System.out.println("2. Search books");
        System.out.println("3. Show my borrowed books");
        System.out.println("4. Borrow book");
        System.out.println("5. Return book");
        System.out.println("0. Sign out");
        System.out.println();

        return 6;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> this.menu.printBooks(this.menu.library.getAllBooks());
            case 2 -> this.menu.changeState(new UserBookSearchMenu(this.menu, this.scanner));
            case 3 -> this.menu.printBorrowedBooks(this.menu.library.getAllOrdersForActualUser());
            case 4 -> this.borrowBook();
            case 5 -> this.returnBook();
            case 0 -> this.menu.changeState(new StartupMenu(this.menu, this.scanner));
        }

        return 0;
    }

    private void borrowBook(){
        this.menu.printBooks(this.menu.library.getAllBooks());

        System.out.print("Provide ISBN: ");
        this.scanner.nextLine();
        String isbn = this.scanner.nextLine();

        if(!this.menu.library.canBookBeBorrowed(isbn)){
            System.out.println("Book cannot be borrowed");
            return;
        }

        this.menu.library.borrowBook(isbn);
        System.out.println("Thank you for new order");
    }

    private void returnBook(){
        this.menu.printBorrowedBooks(this.menu.library.getAllOrdersForActualUser());
        System.out.print("Provide order id: ");
        this.scanner.nextLine();
        int id = this.scanner.nextInt();

        if(this.menu.library.returnBook(id)){
            System.out.println("Book has been returned successfully");
        }else{
            System.out.println("Order not found");
        }
    }

}
