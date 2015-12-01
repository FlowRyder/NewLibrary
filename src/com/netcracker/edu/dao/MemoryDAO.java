package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public class MemoryDAO extends DAO {
    public static final Logger LOGGER = Logger.getLogger(MemoryDAO.class);
    private static MemoryDAO INSTANCE = new MemoryDAO();
    private Collection<Book> books;
    private Collection<Account> accounts;
    private Collection<Author> authors;
    private Collection<Genre> genres;
    private Collection<BookType> bookTypes;
    private Collection<Reader> readers;
    private Collection<Librarian> librarians;
    private Map<IDObject, Collection<IDObject>> complianceMap;

    public static MemoryDAO getInstance() {
        return INSTANCE;
    }

    private MemoryDAO() {
        genres = new HashSet<>();
        authors = new HashSet<>();
        bookTypes = new HashSet<>();
        readers = new HashSet<>();
        books = new HashSet<>();
        accounts = new HashSet<>();
        complianceMap = new HashMap<>(6);
    }

    @Override
    public void add(IDObject idObject) {

    }

    @Override
    public IDObject load(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    public IDObject choose(Collection<? extends IDObject> collection) {
        for (IDObject idObject : collection) {
            System.out.println(idObject.toString());
        }
        LOGGER.info("Enter id:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (IDObject idObject : collection) {
            if (idObject.getId() == id) {
                return idObject;
            }
        }
        return null;
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
}
