package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.persist.FileStorage;
import com.netcracker.edu.util.FileLocation;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by FlowRyder
 */
public class FileDAO implements DAO {
    public static final Logger LOGGER = Logger.getLogger(FileDAO.class);
    private static FileDAO INSTANCE = null;
    private static FileStorage fileStorage;
    private String sourceFileLocation = FileLocation.getFileStorageLocation();

    private ReentrantReadWriteLock accountRWL = new ReentrantReadWriteLock();
    private Lock accountRL = accountRWL.readLock();
    private Lock accountWL = accountRWL.writeLock();

    private ReentrantReadWriteLock authorRWL = new ReentrantReadWriteLock();
    private Lock authorRL = authorRWL.readLock();
    private Lock authorWL = authorRWL.writeLock();

    private ReentrantReadWriteLock bookRWL = new ReentrantReadWriteLock();
    private Lock bookRL = bookRWL.readLock();
    private Lock bookWL = bookRWL.writeLock();

    private ReentrantReadWriteLock bookTypeRWL = new ReentrantReadWriteLock();
    private Lock bookTypeRL = bookTypeRWL.readLock();
    private Lock bookTypeWL = bookTypeRWL.writeLock();

    private ReentrantReadWriteLock genreRWL = new ReentrantReadWriteLock();
    private Lock genreRL = genreRWL.readLock();
    private Lock genreWL = genreRWL.writeLock();

    private ReentrantReadWriteLock userRWL = new ReentrantReadWriteLock();
    private Lock userRL = userRWL.readLock();
    private Lock userWL = userRWL.writeLock();

    private FileDAO() {
        fileStorage = loadFileStorage();
    }

    public static synchronized FileDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileDAO();
        }
        return INSTANCE;
    }

    @Override
    public boolean addAccount(Account account) {
        boolean result;
        accountWL.lock();
        try {
            result = fileStorage.getAccounts().add(account);
        } finally {
            accountWL.unlock();
        }
        return result;
    }

    @Override
    public boolean addAuthor(Author author) {
        boolean result;
        authorWL.lock();
        try {
            result = fileStorage.getAuthors().add(author);
        } finally {
            authorWL.unlock();
        }
        return result;
    }

    @Override
    public boolean addBook(Book book) {
        boolean result;
        bookWL.lock();
        try {
            result = fileStorage.getBooks().add(book);
        } finally {
            bookWL.unlock();
        }
        return result;
    }

    @Override
    public boolean addBookType(BookType bookType) {
        boolean result;
        bookTypeWL.lock();
        try {
            result = fileStorage.getBookTypes().add(bookType);
        } finally {
            bookTypeWL.unlock();
        }
        return result;
    }

    @Override
    public boolean addGenre(Genre genre) {
        boolean result;
        genreWL.lock();
        try {
            result = fileStorage.getGenres().add(genre);
        } finally {
            genreWL.unlock();
        }
        return result;
    }

    @Override
    public boolean addUser(User user) {
        boolean result;
        userWL.lock();
        try {
            result = fileStorage.getUsers().add(user);
        } finally {
            userWL.unlock();
        }
        return result;
    }


    @Override
    public boolean deleteAccount(BigInteger id) {
        boolean result = false;
        accountRL.lock();
        try {
            for (Account account : fileStorage.getAccounts()) {
                if (account.getId().equals(id)) {
                    account.setIsActual(false);
                    result = true;
                }
            }
        } finally {
            accountRL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteAuthor(BigInteger id) {
        boolean result = false;
        authorRL.lock();
        try {
            for (Author author : fileStorage.getAuthors()) {
                if (author.getId().equals(id)) {
                    result = fileStorage.getAuthors().remove(author);
                }
            }
        } finally {
            authorRL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteBook(BigInteger id) {
        boolean result = false;
        bookRL.lock();
        try {
            for (Book book : fileStorage.getBooks()) {
                if (book.getId().equals(id)) {
                    result = fileStorage.getBooks().remove(book);
                }
            }
        } finally {
            bookRL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteBookType(BigInteger id) {
        boolean result = false;
        bookTypeRL.lock();
        try {
            for (BookType bookType : fileStorage.getBookTypes()) {
                if (bookType.getId().equals(id)) {
                    result = fileStorage.getBookTypes().remove(bookType);
                }
            }
        } finally {
            bookTypeRL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteGenre(BigInteger id) {
        boolean result = false;
        genreRL.lock();
        try {
            for (Genre genre : fileStorage.getGenres()) {
                if (genre.getId().equals(id)) {
                    result = fileStorage.getGenres().remove(genre);
                }
            }
        } finally {
            genreRL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteUser(BigInteger id) {
        boolean result = false;
        userRL.lock();
        try {
            for (User user : fileStorage.getUsers()) {
                if (user.getId().equals(id)) {
                    result = fileStorage.getUsers().remove(user);
                }
            }
        } finally {
            userRL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean result = false;
        accountWL.lock();
        try {
            for (Account element : fileStorage.getAccounts()) {
                if (element.getId().equals(account.getId())) {
                    fileStorage.getAccounts().remove(element);
                    fileStorage.getAccounts().add(account);
                    result = true;
                }
            }
        } finally {
            accountWL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateAuthor(Author author) {
        boolean result = false;
        authorWL.lock();
        try {
            for (Author element : fileStorage.getAuthors()) {
                if (element.getId().equals(author.getId())) {
                    fileStorage.getAuthors().remove(element);
                    fileStorage.getAuthors().add(author);
                    result = true;
                }
            }
        } finally {
            authorWL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        bookWL.lock();
        try {
            for (Book element : fileStorage.getBooks()) {
                if (element.getId().equals(book.getId())) {
                    fileStorage.getBooks().remove(element);
                    fileStorage.getBooks().add(book);
                    result = true;
                }
            }
        } finally {
            bookWL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateBookType(BookType bookType) {
        boolean result = false;
        bookTypeWL.lock();
        try {
            for (BookType element : fileStorage.getBookTypes()) {
                if (element.getId().equals(bookType.getId())) {
                    fileStorage.getBookTypes().remove(element);
                    fileStorage.getBookTypes().add(bookType);
                    result = true;
                }
            }
        } finally {
            bookTypeWL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateGenre(Genre genre) {
        boolean result = false;
        genreWL.lock();
        try {
            for (Genre element : fileStorage.getGenres()) {
                if (element.getId().equals(genre.getId())) {
                    fileStorage.getGenres().remove(element);
                    fileStorage.getGenres().add(genre);
                    result = true;
                }
            }
        } finally {
            genreWL.unlock();
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        userWL.lock();
        try {
            for (User element : fileStorage.getUsers()) {
                if (element.getId().equals(user.getId())) {
                    fileStorage.getUsers().remove(element);
                    fileStorage.getUsers().add(user);
                    result = true;
                }
            }
        } finally {
            userWL.unlock();
        }
        return result;
    }

    @Override
    public User findByLogin(String login) {
        userRL.lock();
        try {
            for (User user : fileStorage.getUsers()) {
                if (user.getLogin().equals(login)) {
                    return user;
                }
            }
        } finally {
            userRL.unlock();
        }
        return null;
    }

    @Override
    public String findByAuthor(String authorName) {
        return null;
    }

    @Override
    public String findByGenre(String genreName) {
        return null;
    }

    @Override
    public String findByBook(String bookName) {
        return null;
    }

    private FileStorage loadFileStorage() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(sourceFileLocation);
            objectInputStream = new ObjectInputStream(fileInputStream);
            fileStorage = (FileStorage) objectInputStream.readObject();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("FileStorage successfully has been loaded from file.");
        return fileStorage;
    }

    public void saveFileStorage() {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(sourceFileLocation);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fileStorage);
        } catch (IOException e) {
            LOGGER.warn("Error: FileStorage wasn't save.");
        }
        LOGGER.info("FileStorage successfully has been saved to file.");
    }

}
