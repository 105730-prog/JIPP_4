package org.example.DAL;

import org.example.DAL.models.Author;
import org.example.DAL.models.Book;
import org.example.DAL.models.Order;
import org.example.DAL.models.User;
import org.example.DAL.repositories.AuthorRepository;
import org.example.DAL.repositories.BookRepository;
import org.example.DAL.repositories.OrderRepository;
import org.example.DAL.repositories.UserRepository;
import org.example.DTO.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    private User actualUser;

    public Library() {
        this.bookRepository = new BookRepository();
        this.authorRepository = new AuthorRepository();
        this.userRepository = new UserRepository();
        this.orderRepository = new OrderRepository();
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.getBooks();
    }

    public boolean addBook(Book book) {
        return this.bookRepository.addBook(book);
    }

    public Book findBookByISBN(String isbn){
        return this.bookRepository.findBookByISBN(isbn);
    }

    public boolean canBookBeBorrowed(String isbn){
        return this.bookRepository.canBeBorrowed(isbn);
    }

    public void decreaseAvailableCopies(String isbn){
        this.bookRepository.borrowBook(isbn);
    }

    public void updateBook(Book book){
        this.bookRepository.updateBook(book);
    }

    public boolean deleteBook(String isbn) {
        return this.bookRepository.deleteBook(isbn);
    }

    public List<Book> findBooksByTitle(String title){
        return this.bookRepository.findBooksByTitle(title);
    }

    public List<Book> findBooksByGenre(String genre){
        return this.bookRepository.findBooksByGenre(genre);
    }

    public List<Book> findBooksByAuthorId(int id){
        return this.bookRepository.findBooksByAuthorId(id);
    }

    public Author addAuthor(String name, String surname) {
        return this.authorRepository.addAuthor(name, surname);
    }

    public Author getAuthorById(int id) {
        return this.authorRepository.findAuthorById(id);
    }

    public Author getAuthorByName(String name, String surname) {
        return this.authorRepository.findAuthorByName(name, surname);
    }

    public List<Author> getAllAuthors(){
        return this.authorRepository.getAuthors();
    }

    public User findUserByLogin(String login){
        return this.userRepository.findUserByLogin(login);
    }

    public void addUser(String login, String password, String name, String surname){
        this.userRepository.addUser(name, surname, login, password, "user");
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }

    public List<OrderDTO> getAllOrders(){
        List<Order> orders = this.orderRepository.getOrders();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order : orders){
            Book book = this.bookRepository.findBookByISBN(order.getBookISBN());
            Author author = this.authorRepository.findAuthorById(book.getAuthorId());
            User user = this.userRepository.findUserById(order.getUserId());
            orderDTOS.add(new OrderDTO(order.getId(), book, author, user, order.getOrderDate(), order.getReturnDate()));
        }

        return orderDTOS;
    }

    public List<OrderDTO> getAllOrdersForActualUser(){
        List<Order> orders = this.orderRepository.getAllUserOrders(this.actualUser.getId());
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order : orders){
            Book book = this.bookRepository.findBookByISBN(order.getBookISBN());
            Author author = this.authorRepository.findAuthorById(book.getAuthorId());
            orderDTOS.add(new OrderDTO(order.getId(), book, author, this.actualUser, order.getOrderDate(), order.getReturnDate()));
        }

        return orderDTOS;
    }

    public void borrowBook(String bookISBN){
        this.orderRepository.borrowBook(this.actualUser.getId(), bookISBN);
        this.decreaseAvailableCopies(bookISBN);
    }

    public boolean returnBook(int orderId){
        Order order = this.orderRepository.findOrderById(orderId);
        if(order == null) return false;
        if(this.orderRepository.returnBook(orderId)){
            this.bookRepository.returnBook(order.getBookISBN());
        }
        return true;
    }
}
