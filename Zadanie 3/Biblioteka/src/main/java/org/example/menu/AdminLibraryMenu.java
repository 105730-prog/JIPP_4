package org.example.menu;

import org.example.DAL.models.Author;
import org.example.DAL.models.Book;

import java.util.Scanner;

public class AdminLibraryMenu extends MenuState{

    public AdminLibraryMenu(Menu menu, Scanner scanner){
        super(menu, scanner);
    }

    @Override
    public int showOptions() {

        System.out.println();
        System.out.println("1. Show all books");
        System.out.println("2. Add book");
        System.out.println("3. Update book");
        System.out.println("4. Delete book");
        System.out.println("5. Search books");
        System.out.println("0. Back");
        System.out.println();

        return 6;
    }

    @Override
    public int readOptions(int optionsCount) {
        int option = super.getValueFromUserInput(optionsCount);
        if(option == -1) return 0;

        switch (option){
            case 1 -> this.menu.printBooks(this.menu.library.getAllBooks());
            case 2 -> this.addBook();
            case 3 -> this.updateBook();
            case 4 -> this.deleteBook();
            case 5 -> this.menu.changeState(new BookSearchMenu(this.menu, this.scanner));
            case 0 -> this.menu.changeState(new LibrarianMenu(this.menu, this.scanner));
        }

        return 0;
    }

    private void addBook(){

        Book book = new Book();

        System.out.print("ISBN: ");
        scanner.nextLine();
        String isbn = this.scanner.nextLine();
        Book oldBook = this.menu.library.findBookByISBN(isbn);
        if(oldBook != null){
            System.out.println("Book with provided ISBN already exists");
            return;
        }
        book.setISBN(isbn);
        System.out.print("Title: ");
        book.setTitle(this.scanner.nextLine());
        System.out.print("Author name: ");
        String authorName = this.scanner.nextLine();
        System.out.print("Author surname: ");
        String authorSurname = this.scanner.nextLine();
        Author author = this.menu.library.addAuthor(authorName, authorSurname);
        book.setAuthorId(author.getId());
        System.out.print("Publisher: ");
        book.setPublisher(this.scanner.nextLine());
        System.out.print("Genre: ");
        book.setGenre(this.scanner.nextLine());
        System.out.print("Year of publication: ");
        book.setPublicationYear(this.scanner.nextInt());
        System.out.print("Number of available copies: ");
        book.setAvailableCopies(this.scanner.nextInt());

        if(this.menu.library.addBook(book)){
            System.out.println("New book has been added successfully");
        }
    }

    private void updateBook(){
        this.menu.printBooks(this.menu.library.getAllBooks());
        System.out.print("ISBN: ");
        scanner.nextLine();
        String isbn = this.scanner.nextLine();

        Book oldBook = this.menu.library.findBookByISBN(isbn);
        if(oldBook == null){
            System.out.println("Book with provided ISBN not found");
            return;
        }

        System.out.print("Title (" + oldBook.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("Genre (" + oldBook.getGenre() + "): ");
        String genre = scanner.nextLine();
        System.out.print("Publisher (" + oldBook.getPublisher() + "): ");
        String publisher = scanner.nextLine();
        System.out.print("Publication date (" + oldBook.getPublicationYear() + "): ");
        String date = scanner.nextLine();
        System.out.print("Number of available copies (" + oldBook.getAvailableCopies() + "): ");
        String copies = scanner.nextLine();
        Author author = this.menu.library.getAuthorById(oldBook.getAuthorId());
        System.out.print("Author (" + author.getName() + " " + author.getSurname() + "): ");
        String authorName = scanner.nextLine();

        if(!title.isEmpty()){
            oldBook.setTitle(title);
        }
        if(!genre.isEmpty()){
            oldBook.setGenre(genre);
        }
        if(!publisher.isEmpty()){
            oldBook.setPublisher(publisher);
        }
        if(!date.isEmpty()){
            oldBook.setPublicationYear(Integer.parseInt(date));
        }
        if(!copies.isEmpty()){
            oldBook.setAvailableCopies(Integer.parseInt(copies));
        }
        if(!authorName.isEmpty()){
            String[] authorData = authorName.split(" ");
            Author newAuthor = this.menu.library.addAuthor(authorData[0], authorData[1]);
            oldBook.setAuthorId(newAuthor.getId());
        }

        this.menu.library.updateBook(oldBook);
        System.out.println("Book has been updated successfully");
    }

    private void deleteBook(){
        this.menu.printBooks(this.menu.library.getAllBooks());
        System.out.print("Provide an ISBN number: ");
        scanner.nextLine();
        String isbn = scanner.nextLine();
        if(!this.menu.library.deleteBook(isbn)){
            System.out.println("Book with ISBN " + isbn + " not found");
        }else{
            System.out.println("Book with ISBN " + isbn + " has been deleted successfully");
        }
    }

}
