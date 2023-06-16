package org.example.DAL.repositories;

import org.example.DAL.models.Author;
import org.example.DAL.models.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private int lastId = 0;
    private final List<Author> authors;

    public AuthorRepository(){
        this.authors = new ArrayList<>();
        this.addAuthor("Adam", "Mickiewicz");
        this.addAuthor("Boleslaw", "Prus");
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Author findAuthorByName(String name, String surname){
        return this.authors.stream().filter(a -> a.getName().equals(name) && a.getSurname().equals(surname)).findFirst().orElse(null);
    }

    public Author findAuthorById(int id){
        return this.authors.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Author addAuthor(String name, String surname){
        Author oldAuthor = this.findAuthorByName(name, surname);
        if(oldAuthor == null){
            Author author = new Author();
            author.setId(lastId);
            author.setName(name);
            author.setSurname(surname);
            lastId++;
            this.authors.add(author);
            return author;
        }
        return oldAuthor;
    }
}
