package org.example.menu;

import org.example.DAL.Library;
import org.example.DAL.models.Author;
import org.example.DAL.models.Book;
import org.example.DTO.OrderDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private MenuState menuState;
    public Library library;
    private final Scanner scanner;

    public Menu(Scanner scanner, Library library){
        this.scanner = scanner;
        this.menuState = new StartupMenu(this, scanner);
        this.library = library;
    }

    public void changeState(MenuState state) {
        this.menuState = state;
    }

    public MenuState getState() {
        return menuState;
    }

    public void printBooks(List<Book> books){
        for(Book book : books){
            System.out.println(book);
            System.out.println("Author: " + this.library.getAuthorById(book.getAuthorId()));
            System.out.println("-----");
        }
    }

    public void printAuthors(List<Author> authors){
        for (Author author : authors){
            System.out.println(author);
            System.out.println("-----");
        }
    }

    public void findBooksByTitle(){
        System.out.print("Provide part of book title: ");
        scanner.nextLine();

        String title = scanner.nextLine();
        List<Book> books = this.library.findBooksByTitle(title);
        System.out.println(books.size() + " books founded");
        this.printBooks(books);
    }

    public void findBooksByAuthor(){

        this.printAuthors(this.library.getAllAuthors());

        System.out.print("Provide author name and username: ");
        scanner.nextLine();

        String[] authorData = scanner.nextLine().split(" ");
        Author author = this.library.getAuthorByName(authorData[0], authorData[1]);
        if(author == null){
            System.out.println("Author not found");
            return;
        }

        List<Book> books = this.library.findBooksByAuthorId(author.getId());
        System.out.println(books.size() + " books founded");
        this.printBooks(books);
    }

    public void findBooksByGenre(){
        System.out.print("Provide part of book genre: ");
        scanner.nextLine();

        String genre = scanner.nextLine();
        List<Book> books = this.library.findBooksByGenre(genre);
        System.out.println(books.size() + " books founded");
        this.printBooks(books);

    }

    public void printBorrowedBooks(List<OrderDTO> orderDTOS){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(OrderDTO orderDTO : orderDTOS){
            System.out.println("Order id: " + orderDTO.getOrderId());
            System.out.println("Title: " + orderDTO.getBook().getTitle());
            System.out.println("Genre: " + orderDTO.getBook().getGenre());
            System.out.println("Publisher: " + orderDTO.getBook().getPublisher());
            System.out.println("Published date: " + orderDTO.getBook().getPublicationYear());
            System.out.println("ISBN: " + orderDTO.getBook().getISBN());
            System.out.println("Author: " + orderDTO.getAuthor());
            System.out.println("Borrowed by " + orderDTO.getUser());
            System.out.println("Borrowed date: " + orderDTO.getBorrowedTime().format(df));
            System.out.println("Return date: " + orderDTO.getReturnTime().format(df));
            System.out.println("-----");
        }
    }
}
