package com.netcracker.edu.dao;

/**
 * Created by FlowRyder
 */

import com.netcracker.edu.businessobjects.*;

import java.math.BigInteger;

public interface DAO {
    boolean addAccount(Account account);

    boolean addAuthor(Author author);

    boolean addBook(Book book);

    boolean addBookType(BookType bookType);

    boolean addGenre(Genre genre);

    boolean addUser(User user);

    boolean deleteAccount(BigInteger id);

    boolean deleteAuthor(BigInteger id);

    boolean deleteBook(BigInteger id);

    boolean deleteBookType(BigInteger id);

    boolean deleteGenre(BigInteger id);

    boolean deleteUser(BigInteger id);

    boolean updateAccount(Account account);

    boolean updateAuthor(Author author);

    boolean updateBook(Book book);

    boolean updateBookType(BookType bookType);

    boolean updateGenre(Genre genre);

    boolean updateUser(User user);

    User findByLogin(String login);
}
