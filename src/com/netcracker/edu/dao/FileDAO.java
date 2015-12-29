package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.util.Load;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by FlowRyder on 29.12.2015.
 */
public class FileDAO {
    public static final Logger LOGGER = Logger.getLogger(FileDAO.class);
    private static FileDAO INSTANCE = new FileDAO();
    private Collection<Book> books;
    private Collection<Account> accounts;
    private Collection<Author> authors;
    private Collection<Genre> genres;
    private Collection<BookType> bookTypes;
    private Collection<Reader> readers;
    private Collection<Librarian> librarians;

    private FileDAO() {
        genres = (Collection<Genre>) Load.loadCollection("genre");
        authors = (Collection<Author>) Load.loadCollection("author");
        bookTypes = (Collection<BookType>) Load.loadCollection("booktype");
        readers = (Collection<Reader>) Load.loadCollection("reader");
        books = (Collection<Book>) Load.loadCollection("book");
        accounts = (Collection<Account>) Load.loadCollection("account");
        librarians = (Collection<Librarian>) Load.loadCollection("librarian");
    }

    public static FileDAO getInstance() {
        return INSTANCE;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public Collection<BookType> getBookTypes() {
        return bookTypes;
    }

    public Collection<Reader> getReaders() {
        return readers;
    }

    public Collection<Librarian> getLibrarians() {
        return librarians;
    }
}
