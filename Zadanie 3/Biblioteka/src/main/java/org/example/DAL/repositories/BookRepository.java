package org.example.DAL.repositories;

import org.example.DAL.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
        this.addBook(new Book("Pan Tadeusz", 0, "GREG", "Poetry", "123123122", 2020, 10));
        this.addBook(new Book("Sonety Krymskie", 0, "GREG", "Poems", "123123123", 2021, 30));
        this.addBook(new Book("Lalka", 1, "Nasza Ksiegarnia", "Drama", "123123124", 2022, 20));
        this.addBook(new Book("Katarynka", 1, "Nasza Ksiegarnia", "Novel", "123123125", 2023, 25));
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean addBook(Book book) {
        Book oldBook = findBookByISBN(book.getISBN());
        if (oldBook != null) return false;
        this.books.add(book);
        return true;
    }

    public void updateBook(Book book) {
        this.deleteBook(book.getISBN());
        this.addBook(book);
    }

    public Book findBookByISBN(String isbn) {
        return this.books.stream().filter(b -> b.getISBN().equals(isbn)).findFirst().orElse(null);
    }

    public List<Book> findBooksByTitle(String title){
        return this.books.stream().filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

    public List<Book> findBooksByGenre(String genre){
        return this.books.stream().filter(b -> b.getGenre().toLowerCase().contains(genre.toLowerCase())).toList();
    }

    public boolean canBeBorrowed(String isbn){
        Book book = this.findBookByISBN(isbn);
        return book != null && book.getAvailableCopies() != 0;
    }

    public void borrowBook(String isbn){
        Book book = this.findBookByISBN(isbn);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.deleteBook(isbn);
        this.addBook(book);
    }

    public void returnBook(String isbn){
        Book book = this.findBookByISBN(isbn);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        this.deleteBook(isbn);
        this.addBook(book);
    }

    public List<Book> findBooksByAuthorId(int id){
        return this.books.stream().filter(b -> b.getAuthorId() == id).toList();
    }

    public boolean deleteBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            return false;
        }

        this.books.remove(book);
        return true;
    }
}
