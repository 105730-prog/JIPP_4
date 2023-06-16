package org.example.DAL.repositories;

import org.example.DAL.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> users;
    private int lastId = 0;

    public UserRepository() {
        this.users = new ArrayList<>();
        this.addUser("Jan", "Nowak", "admin", "admin", "librarian");
        this.addUser("Adam", "Krawczyk", "user", "user", "user");
    }

    public User findUserById(int id){
        return this.users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public User findUserByLogin(String login){
        return this.users.stream().filter(u -> u.getLogin().equalsIgnoreCase(login)).findFirst().orElse(null);
    }

    public void addUser(String name, String surname, String login, String password, String role){
        this.users.add(new User(lastId, name, surname, login, password, role));
        lastId++;
    }

    public List<User> getUsers() {
        return users;
    }
}
