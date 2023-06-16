package org.example.DAL.models;

import org.example.DAL.repositories.OrderRepository;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private int userId;
    private String bookISBN;

    private LocalDateTime orderDate, returnDate;

    public Order(){

    }

    public Order(int id, int userId, String bookISBN){
        this.id = id;
        this.userId = userId;
        this.bookISBN = bookISBN;
        this.orderDate = LocalDateTime.now();
        this.returnDate = LocalDateTime.now().plusDays(10);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
