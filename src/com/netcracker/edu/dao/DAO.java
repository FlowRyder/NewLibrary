package com.netcracker.edu.dao;

/**
 * Created by FlowRyder
 */

import com.netcracker.edu.businessobjects.*;

import java.math.BigInteger;
import java.sql.SQLException;

public interface DAO {
    boolean addAccount(Account account) throws SQLException;

    boolean addAuthor(Author author) throws SQLException;

    boolean addBook(Book book) throws SQLException;

    boolean addBookType(BookType bookType) throws SQLException;

    boolean addGenre(Genre genre) throws SQLException;

    boolean addUser(User user) throws SQLException;

    boolean deleteAccount(BigInteger id) throws SQLException;

    boolean deleteAuthor(BigInteger id) throws SQLException;

    boolean deleteBook(BigInteger id) throws SQLException;

    boolean deleteBookType(BigInteger id) throws SQLException;

    boolean deleteGenre(BigInteger id) throws SQLException;

    boolean deleteUser(BigInteger id) throws SQLException;

    boolean updateAccount(Account account) throws SQLException;

    boolean updateAuthor(Author author) throws SQLException;

    boolean updateBook(Book book) throws SQLException;

    boolean updateBookType(BookType bookType) throws SQLException;

    boolean updateGenre(Genre genre) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User findByLogin(String login) throws SQLException;
}
