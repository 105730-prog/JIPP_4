package libProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        Bookshelf bookshelf = new Bookshelf();

        while(shouldContinue) {
            System.out.println("Choose an option");
            System.out.println("1. Display Books");
            System.out.println("2. Add Book");
            System.out.println("3. Display Authors");
            System.out.println("4. Find by ISBN Number");
            System.out.println("5. Exit App");

            int userChoice = scanner.nextInt();

            switch(userChoice) {
                case 1 -> bookshelf.displayBooks();
                case 2 -> bookshelf.addBook();
                case 3 -> bookshelf.displayAuthors();
                case 4 -> bookshelf.displayBookByIsbnNumber();
                case 5 -> shouldContinue = false;

            }
        }
    }
}