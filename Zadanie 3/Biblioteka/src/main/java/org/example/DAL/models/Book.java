package org.example.DAL.models;

import org.example.DAL.repositories.BookRepository;

public class Book {

    private String title;
    private int authorId;
    private String publisher;
    private String genre;
    private String ISBN;
    private int publicationYear;
    private int availableCopies;

    public Book(){

    }

    public Book(String title, int authorId, String publisher, String genre, String ISBN, int publicationYear, int availableCopies) {
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.genre = genre;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "ISBN: " +
                this.getISBN() +
                "\n" +
                "Title: " +
                this.getTitle() +
                "\n" +
                "Genre: " +
                this.getGenre() +
                "\n" +
                "Publisher: " +
                this.getPublisher() +
                "\n" +
                "Publication date: " +
                this.getPublicationYear() +
                "\n" +
                "Number of available copies: " +
                this.getAvailableCopies();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
