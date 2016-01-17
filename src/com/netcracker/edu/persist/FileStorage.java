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
  //  private HashSet<Librarian> librarians;
  //  private HashSet<Reader> readers;

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

 /*   public HashSet<Librarian> getLibrarians() {
        if (librarians == null) {
            librarians = new HashSet<>();
        }
        return librarians;
    }

    public HashSet<Reader> getReaders() {
        if (readers == null) {
            readers = new HashSet<>();
        }
        return readers;
    }*/
}
