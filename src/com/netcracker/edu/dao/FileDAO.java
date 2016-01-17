package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.persist.FileStorage;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by FlowRyder
 */
public class FileDAO /*implements DAO*/ {
    /*public static final Logger LOGGER = Logger.getLogger(FileDAO.class);
    private static FileDAO INSTANCE = null;
    private static FileStorage fileStorage;
    private String sourceFileLocation = "C:\\Users\\FlowRyder\\IdeaProjects\\" +
            "Library\\src\\com\\netcracker\\edu\\data\\FILESTORAGE.dat";

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

    private ReentrantReadWriteLock readerRWL = new ReentrantReadWriteLock();
    private Lock readerRL = readerRWL.readLock();
    private Lock readerWL = readerRWL.writeLock();

    private ReentrantReadWriteLock librarianRWL = new ReentrantReadWriteLock();
    private Lock librarianRL = librarianRWL.readLock();
    private Lock librarianWL = librarianRWL.writeLock();

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
    public void addAccount(Account account) {
        accountWL.lock();
        try {
            fileStorage.getAccounts().add(account);
        } finally {
            accountWL.unlock();
        }
    }

    @Override
    public void addAuthor(Author author) {
        authorWL.lock();
        try {
            fileStorage.getAuthors().add(author);
        } finally {
            authorWL.unlock();
        }
    }

    @Override
    public void addBook(Book book) {
        bookWL.lock();
        try {
            fileStorage.getBooks().add(book);
        } finally {
            bookWL.unlock();
        }
    }

    @Override
    public void addBookType(BookType bookType) {
        bookTypeWL.lock();
        try {
            fileStorage.getBookTypes().add(bookType);
        } finally {
            bookTypeWL.unlock();
        }
    }

    @Override
    public void addGenre(Genre genre) {
        genreWL.lock();
        try {
            fileStorage.getGenres().add(genre);
        } finally {
            genreWL.unlock();
        }
    }

    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void addReader(Reader reader) {
        readerWL.lock();
        try {
            fileStorage.getReaders().add(reader);
        } finally {
            readerWL.unlock();
        }
    }

    @Override
    public void addLibrarian(Librarian librarian) {
        librarianWL.lock();
        try {
            fileStorage.getLibrarians().add(librarian);
        } finally {
            librarianWL.unlock();
        }
    }

    @Override
    public Account loadAccount(BigInteger id) {
        accountRL.lock();
        Account account = null;
        try {
            for (Account element : fileStorage.getAccounts()) {
                if (element.getId().equals(id)) {
                    account = element;
                }
            }
            return account;
        } finally {
            accountRL.unlock();
        }
    }

    @Override
    public Author loadAuthor(BigInteger id) {
        authorRL.lock();
        Author author = null;
        try {
            for (Author element : fileStorage.getAuthors()) {
                if (element.getId().equals(id)) {
                    author = element;
                }
            }
            return author;
        } finally {
            authorRL.unlock();
        }
    }

    @Override
    public Book loadBook(BigInteger id) {
        bookRL.lock();
        Book book = null;
        try {
            for (Book element : fileStorage.getBooks()) {
                if (element.getId().equals(id)) {
                    book = element;
                }
            }
            return book;
        } finally {
            bookRL.unlock();
        }
    }

    @Override
    public BookType loadBookType(BigInteger id) {
        bookTypeRL.lock();
        BookType bookType = null;
        try {
            for (BookType element : fileStorage.getBookTypes()) {
                if (element.getId().equals(id)) {
                    bookType = element;
                }
            }
            return bookType;
        } finally {
            bookTypeRL.unlock();
        }
    }

    @Override
    public Genre loadGenre(BigInteger id) {
        genreRL.lock();
        Genre genre = null;
        try {
            for (Genre element : fileStorage.getGenres()) {
                if (element.getId().equals(id)) {
                    genre = element;
                }
            }
            return genre;
        } finally {
            genreRL.unlock();
        }
    }

    @Override
    public Reader loadReader(BigInteger id) {
        readerRL.lock();
        Reader reader = null;
        try {
            for (Reader element : fileStorage.getReaders()) {
                if (element.getId().equals(id)) {
                    reader = element;
                }
            }
            return reader;
        } finally {
            readerRL.unlock();
        }
    }

    @Override
    public Librarian loadLibrarian(BigInteger id) {
        librarianRL.lock();
        Librarian librarian = null;
        try {
            for (Librarian element : fileStorage.getLibrarians()) {
                if (element.getId().equals(id)) {
                    librarian = element;
                }
            }
            return librarian;
        } finally {
            librarianRL.unlock();
        }
    }

    @Override
    public boolean deleteAccount(Account account) {
        boolean result;
        accountWL.lock();
        try {
            result = fileStorage.getAccounts().remove(account);
        } finally {
            accountWL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteAuthor(Author author) {
        boolean result;
        authorWL.lock();
        try {
            result = fileStorage.getAuthors().remove(author);
        } finally {
            authorWL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteBook(Book book) {
        boolean result;
        bookWL.lock();
        try {
            result = fileStorage.getBooks().remove(book);
        } finally {
            bookWL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteBookType(BookType bookType) {
        boolean result;
        bookTypeWL.lock();
        try {
            result = fileStorage.getBookTypes().remove(bookType);
        } finally {
            bookTypeWL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteGenre(Genre genre) {
        boolean result;
        genreWL.lock();
        try {
            result = fileStorage.getGenres().remove(genre);
        } finally {
            genreWL.unlock();
        }
        return result;
    }

    @Override
    public void deleteUser(User user) throws SQLException {

    }

    @Override
    public boolean deleteReader(Reader reader) {
        boolean result;
        readerWL.lock();
        try {
            result = fileStorage.getReaders().remove(reader);
        } finally {
            readerWL.unlock();
        }
        return result;
    }

    @Override
    public boolean deleteLibrarian(Librarian librarian) {
        boolean result;
        librarianWL.lock();
        try {
            result = fileStorage.getLibrarians().remove(librarian);
        } finally {
            librarianWL.unlock();
        }
        return result;
    }

    @Override
    public void updateAccount(Account account) {
        accountWL.lock();
        try {
            for (Account element : fileStorage.getAccounts()) {
                if (element.getId().equals(account.getId())) {
                    fileStorage.getAccounts().remove(element);
                    fileStorage.getAccounts().add(account);
                }
            }
        } finally {
            accountWL.unlock();
        }
    }

    @Override
    public void updateAuthor(Author author) {
        authorWL.lock();
        try {
            for (Author element : fileStorage.getAuthors()) {
                if (element.getId().equals(author.getId())) {
                    fileStorage.getAuthors().remove(element);
                    fileStorage.getAuthors().add(author);
                }
            }
        } finally {
            authorWL.unlock();
        }
    }

    @Override
    public void updateBook(Book book) {
        bookWL.lock();
        try {
            for (Book element : fileStorage.getBooks()) {
                if (element.getId().equals(book.getId())) {
                    fileStorage.getBooks().remove(element);
                    fileStorage.getBooks().add(book);
                }
            }
        } finally {
            bookWL.unlock();
        }
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeWL.lock();
        try {
            for (BookType element : fileStorage.getBookTypes()) {
                if (element.getId().equals(bookType.getId())) {
                    fileStorage.getBookTypes().remove(element);
                    fileStorage.getBookTypes().add(bookType);
                }
            }
        } finally {
            bookTypeWL.unlock();
        }
    }

    @Override
    public void updateGenre(Genre genre) {
        genreWL.lock();
        try {
            for (Genre element : fileStorage.getGenres()) {
                if (element.getId().equals(genre.getId())) {
                    fileStorage.getGenres().remove(element);
                    fileStorage.getGenres().add(genre);
                }
            }
        } finally {
            genreWL.unlock();
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {

    }

    @Override
    public void updateReader(Reader reader) {
        readerWL.lock();
        try {
            for (Reader element : fileStorage.getReaders()) {
                if (element.getId().equals(reader.getId())) {
                    fileStorage.getReaders().remove(element);
                    fileStorage.getReaders().add(reader);
                }
            }
        } finally {
            readerWL.unlock();
        }
    }

    @Override
    public void updateLibrarian(Librarian librarian) {
        librarianWL.lock();
        try {
            for (Librarian element : fileStorage.getLibrarians()) {
                if (element.getId().equals(librarian.getId())) {
                    fileStorage.getLibrarians().remove(element);
                    fileStorage.getLibrarians().add(librarian);
                }
            }
        } finally {
            accountWL.unlock();
        }
    }

    @Override
    public User findByLogin(String login) {
        librarianRL.lock();
        try {
            for (Librarian librarian : fileStorage.getLibrarians()) {
                if (librarian.getLogin().equals(login)) {
                    return librarian;
                }
            }
        } finally {
            librarianRL.unlock();
        }
        readerRL.lock();
        try {
            for (Reader reader : fileStorage.getReaders()) {
                if (reader.getLogin().equals(login)) {
                    return reader;
                }
            }
        } finally {
            readerRL.unlock();
        }
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

    // temporary method for choose ID by user.
    public void show() {
        LOGGER.info("Readers");
        for (Reader reader : fileStorage.getReaders()) {
            LOGGER.info(reader.toString());
        }
        LOGGER.info("Librarians");
        for (Librarian librarian : fileStorage.getLibrarians()) {
            LOGGER.info(librarian.toString());
        }
        LOGGER.info("Genres");
        for (Genre genre : fileStorage.getGenres()) {
            LOGGER.info(genre.toString());
        }
        LOGGER.info("Authors");
        for (Author author : fileStorage.getAuthors()) {
            LOGGER.info(author.toString());
        }
        LOGGER.info("Books");
        for (Book book : fileStorage.getBooks()) {
            LOGGER.info(book.toString());
        }
        LOGGER.info("BookTypes");
        for (BookType bookType : fileStorage.getBookTypes()) {
            LOGGER.info(bookType.toString());
        }
        LOGGER.info("Accounts");
        for (Account account : fileStorage.getAccounts()) {
            LOGGER.info(account.toString());
        }
    }*/
}
