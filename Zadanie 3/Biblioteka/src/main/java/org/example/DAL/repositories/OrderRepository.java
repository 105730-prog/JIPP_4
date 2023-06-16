package org.example.DAL.repositories;

import org.example.DAL.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders;
    private int lastId = 0;

    public OrderRepository(){
        this.orders = new ArrayList<>();
    }

    public void borrowBook(int userId, String bookISBN){
        this.orders.add(new Order(lastId, userId, bookISBN));
        this.lastId++;
    }

    public boolean returnBook(int orderId){
        Order order = this.findOrderById(orderId);
        if(order == null) return false;
        this.orders.remove(order);
        return true;
    }

    public Order findOrderById(int orderId){
        return this.orders.stream().filter(o -> o.getId() == orderId).findFirst().orElse(null);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getAllUserOrders(int userId){
        return this.orders.stream().filter(o -> o.getUserId() == userId).toList();
    }
}
