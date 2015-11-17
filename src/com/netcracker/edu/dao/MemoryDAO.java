package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by FlowRyder on 16.11.2015.
 */
public class MemoryDAO {
    private static MemoryDAO INSTANCE = new MemoryDAO();
    private HashSet<Book> books;
    private HashSet<Account> accounts;
    private HashSet<Author> authors;
    private HashSet<Genre> genres;
    private HashSet<BookType> bookTypes;
    private HashSet<Reader> readers;
    private HashSet<Librarian> librarians;

    private MemoryDAO() {
        genres = new HashSet<>(1);
        authors = new HashSet<>(1);
        bookTypes = new HashSet<>(1);
        readers = new HashSet<>(2);
        books = new HashSet<>(4);
        accounts = new HashSet<>(4);
        initialize();
    }

    public static MemoryDAO getInstance() {
        return INSTANCE;
    }

    public Genre findGenreByName(String name) {
        Iterator<Genre> genreIterator = genres.iterator();
        while (genreIterator.hasNext()) {
            Genre genre = genreIterator.next();
            if (name.equals(genre.getName())) {
                return genre;
            }
        }
        return null;
    }

    public Author findAuthorByName(String name) {
        Iterator<Author> authorIterator = authors.iterator();
        while (authorIterator.hasNext()) {
            Author author = authorIterator.next();
            if (name.equals(author.getName())) {
                return author;
            }
        }
        return null;
    }

    public BookType findBookTypeByName(String name) {
        Iterator<BookType> bookTypeIterator = bookTypes.iterator();
        while (bookTypeIterator.hasNext()) {
            BookType bookType = bookTypeIterator.next();
            if (name.equals(bookType.getName())) {
                return bookType;
            }
        }
        return null;
    }

    public Reader findReaderByLogin(String login) {
        Iterator<Reader> readerIterator = readers.iterator();
        while (readerIterator.hasNext()) {
            Reader reader = readerIterator.next();
            if (login.equals(reader.getLogin())) {
                return reader;
            }
        }
        return null;
    }

    public Book findBookByID(int id) {
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }

    public Account findAccountByID(int id) {
        Iterator<Account> accountIterator = accounts.iterator();
        while (accountIterator.hasNext()) {
            Account account = accountIterator.next();
            if (id == account.getId()) {
                return account;
            }
        }
        return null;
    }

    // This method added just for testing system.
    public void initialize() {
        Genre genre = new Genre("novel");
        genres.add(genre);
        Author author = new Author("Pelevin");
        authors.add(author);
        BookType bookType = new BookType("Generation Pi", genre, author);
        bookTypes.add(bookType);
        Reader readerPetya = new Reader("Petya", "nagibator", "petya99@mail.ru", "1234abCD");
        Reader readerIvan = new Reader("Ivan", "playersNightmare", "ivan05@mail.ru", "IVan9876");
        readers.add(readerPetya);
        readers.add(readerIvan);
        Book[] books = new Book[4];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(bookType);
            this.books.add(books[i]);
        }
        Account[] accounts = new Account[4];
        for (int i = 0; i < accounts.length; i++) {
            Calendar returnDate = Calendar.getInstance();
            returnDate.add(Calendar.MONTH, i);
            if (i % 2 == 0) {
                accounts[i] = new Account(readerIvan, books[i], Calendar.getInstance(), returnDate);
            } else {
                accounts[i] = new Account(readerPetya, books[i], Calendar.getInstance(), returnDate);
            }
            this.accounts.add(accounts[i]);
        }
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public HashSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashSet<Account> accounts) {
        this.accounts = accounts;
    }

    public HashSet<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(HashSet<Author> authors) {
        this.authors = authors;
    }

    public HashSet<Genre> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<Genre> genres) {
        this.genres = genres;
    }

    public HashSet<BookType> getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(HashSet<BookType> bookTypes) {
        this.bookTypes = bookTypes;
    }

    public HashSet<Reader> getReaders() {
        return readers;
    }

    public void setReaders(HashSet<Reader> readers) {
        this.readers = readers;
    }

    public HashSet<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(HashSet<Librarian> librarians) {
        this.librarians = librarians;
    }
}
