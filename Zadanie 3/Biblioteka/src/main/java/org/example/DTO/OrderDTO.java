package org.example.DTO;

import org.example.DAL.models.Author;
import org.example.DAL.models.Book;
import org.example.DAL.models.User;

import java.time.LocalDateTime;

public class OrderDTO {

    private int orderId;
    private Book book;
    private Author author;
    private User user;
    private LocalDateTime borrowedTime, returnTime;


    public OrderDTO(int orderId, Book book, Author author, User user, LocalDateTime borrowedTime, LocalDateTime returnTime) {
        this.orderId = orderId;
        this.book = book;
        this.author = author;
        this.user = user;
        this.borrowedTime = borrowedTime;
        this.returnTime = returnTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDateTime borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }
}
