package com.netcracker.edu.persist;

import com.netcracker.edu.businessobjects.*;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by FlowRyder
 */
public class FileStorage implements Serializable {
    private HashSet<Genre> genres;
    private HashSet<Author> authors;
    private HashSet<BookType> bookTypes;
    private HashSet<Book> books;
    private HashSet<Account> accounts;
    private HashSet<User> users;

    public HashSet<Genre> getGenres() {
        if (genres == null) {
            genres = new HashSet<>();
        }
        return genres;
    }

    public HashSet<Author> getAuthors() {
        if (authors == null) {
            authors = new HashSet<>();
        }
        return authors;
    }

    public HashSet<BookType> getBookTypes() {
        if (bookTypes == null) {
            bookTypes = new HashSet<>();
        }
        return bookTypes;
    }

    public HashSet<Book> getBooks() {
        if (books == null) {
            books = new HashSet<>();
        }
        return books;
    }

    public HashSet<Account> getAccounts() {
        if (accounts == null) {
            accounts = new HashSet<>();
        }
        return accounts;
    }

    public HashSet<User> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

}
