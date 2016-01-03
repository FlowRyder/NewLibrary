package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by FlowRyder on 29.12.2015.
 */
public class Load {
    public static final Logger LOGGER = Logger.getLogger(Load.class);

    public static Collection<Book> loadBooks() {
        File bookFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\book.txt");
        HashSet<Book> books = new HashSet<>();
        try (FileReader bookReader = new FileReader(bookFile)) {
            char[] bookBuffer = new char[(int) bookFile.length()];
            bookReader.read(bookBuffer);
            String[] bookLines = new String(bookBuffer).split("\\r?\\n");
            for (String bookString : bookLines) {
                String[] bookInfo = bookString.split(" ");
                Book book = null;
                book = book.load(bookInfo);
                books.add(book);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return books;
    }

    public static Collection<Account> loadAccounts(){
        File accountFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\account.txt");
        HashSet<Account> accounts = new HashSet<>();
        try (FileReader accountReader = new FileReader(accountFile)) {
            char[] accountBuffer = new char[(int) accountFile.length()];
            accountReader.read(accountBuffer);
            String[] accountLines = new String(accountBuffer).split("\\r?\\n");
            for (String accountString : accountLines) {
                String[] accountInfo = accountString.split(" ");
                Account account = null;
                account = account.load(accountInfo);
                accounts.add(account);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return accounts;
    }

    public static Collection<Author> loadAuthors(){
        File authorFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\author.txt");
        HashSet<Author> authors = new HashSet<>();
        try (FileReader authorReader = new FileReader(authorFile)) {
            char[] authorBuffer = new char[(int) authorFile.length()];
            authorReader.read(authorBuffer);
            String[] authorLines = new String(authorBuffer).split("\\r?\\n");
            for (String authorString : authorLines) {
                String[] authorInfo = authorString.split(" ");
                Author author = null;
                author = author.load(authorInfo);
                authors.add(author);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return authors;
    }

    public static Collection<Genre> loadGenres(){
        File genreFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\genre.txt");
        HashSet<Genre> genres = new HashSet<>();
        try (FileReader genreReader = new FileReader(genreFile)) {
            char[] genreBuffer = new char[(int) genreFile.length()];
            genreReader.read(genreBuffer);
            String[] genreLines = new String(genreBuffer).split("\\r?\\n");
            for (String genreString : genreLines) {
                String[] genreInfo = genreString.split(" ");
                Genre genre = null;
                genre = genre.load(genreInfo);
                genres.add(genre);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return genres;
    }

    public static Collection<Reader> loadReader(){
        File readerFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\reader.txt");
        HashSet<Reader> readers = new HashSet<>();
        try (FileReader readerReader = new FileReader(readerFile)) {
            char[] readerBuffer = new char[(int) readerFile.length()];
            readerReader.read(readerBuffer);
            String[] readerLines = new String(readerBuffer).split("\\r?\\n");
            for (String readerString : readerLines) {
                String[] readerInfo = readerString.split(" ");
                Reader reader = null;
                reader = reader.load(readerInfo);
                readers.add(reader);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return readers;
    }

    public static Collection<BookType> loadBookTypes() {
        File booktypeFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\booktype.txt");
        HashSet<BookType> booktypes = new HashSet<>();
        try (FileReader booktypeReader = new FileReader(booktypeFile)) {
            char[] booktypeBuffer = new char[(int) booktypeFile.length()];
            booktypeReader.read(booktypeBuffer);
            String[] booktypeLines = new String(booktypeBuffer).split("\\r?\\n");
            for (String booktypeString : booktypeLines) {
                String[] booktypeInfo = booktypeString.split(" ");
                BookType bookType = null;
                bookType = bookType.load(booktypeInfo);
                booktypes.add(bookType);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return booktypes;
    }

    public static Collection<Librarian> loadLibrarians(){
        File librarianFile = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\librarian.txt");
        HashSet<Librarian> librarians = new HashSet<>();
        try (FileReader librarianReader = new FileReader(librarianFile)) {
            char[] librarianBuffer = new char[(int) librarianFile.length()];
            librarianReader.read(librarianBuffer);
            String[] librarianLines = new String(librarianBuffer).split("\\r?\\n");
            for (String librarianString : librarianLines) {
                String[] librarianInfo = librarianString.split(" ");
                Librarian librarian = null;
                librarian = librarian.load(librarianInfo);
                librarians.add(librarian);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return librarians;
    }

}
