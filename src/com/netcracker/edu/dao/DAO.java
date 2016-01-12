package com.netcracker.edu.dao;

/**
 * Created by FlowRyder
 */

import com.netcracker.edu.businessobjects.*;

import java.math.BigInteger;
import java.sql.SQLException;

public interface DAO {
    void addAccount(Account account);

    void addAuthor(Author author) throws SQLException;

    void addBook(Book book) throws SQLException;

    void addBookType(BookType bookType) throws SQLException;

    void addGenre(Genre genre) throws SQLException;

    void addReader(Reader reader) throws SQLException;

    void addLibrarian(Librarian librarian) throws SQLException;

    Account loadAccount(BigInteger id);

    Author loadAuthor(BigInteger id);

    Book loadBook(BigInteger id);

    BookType loadBookType(BigInteger id);

    Genre loadGenre(BigInteger id);

    Reader loadReader(BigInteger id);

    Librarian loadLibrarian(BigInteger id);

    boolean deleteAccount(Account account);

    boolean deleteAuthor(Author author);

    boolean deleteBook(Book book);

    boolean deleteBookType(BookType bookType);

    boolean deleteGenre(Genre genre);

    boolean deleteReader(Reader reader);

    boolean deleteLibrarian(Librarian librarian);

    void updateAccount(Account account);

    void updateAuthor(Author author);

    void updateBook(Book book);

    void updateBookType(BookType bookType);

    void updateGenre(Genre genre);

    void updateReader(Reader reader);

    void updateLibrarian(Librarian librarian);

    User findByLogin(String login);
}
