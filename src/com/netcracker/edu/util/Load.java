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

    public static Collection<? extends IDObject> loadCollection(String collectionName) {
        String path = "C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\";
        switch (collectionName) {
            case "book":
                break;
            case "account":
                break;
            case "author":
                File authorFile = new File(path + collectionName + ".txt");
                HashSet<Author> authors = new HashSet<>();
                try (FileReader authorReader = new FileReader(authorFile)) {
                    char[] authorBuffer = new char[(int) authorFile.length()];
                    authorReader.read(authorBuffer);
                    String[] authorLines = new String(authorBuffer).split("\\r?\\n");
                    for (String authorString : authorLines) {
                        String[] authorInfo = authorString.split(" ");
                        Author author = new Author(authorInfo[0]);
                        author.setId(Integer.parseInt(authorInfo[1]));
                        authors.add(author);
                    }
                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
                return authors;
            case "genre":
                File genreFile = new File(path + collectionName + ".txt");
                HashSet<Genre> genres = new HashSet<>();
                try (FileReader genreReader = new FileReader(genreFile)) {
                    char[] genreBuffer = new char[(int) genreFile.length()];
                    genreReader.read(genreBuffer);
                    String[] genreLines = new String(genreBuffer).split("\\r?\\n");
                    for (String genreString : genreLines) {
                        String[] genreInfo = genreString.split(" ");
                        Genre genre = new Genre(genreInfo[0]);
                        genre.setId(Integer.parseInt(genreInfo[1]));
                        genres.add(genre);
                    }
                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
                return genres;
            case "reader":
                File readerFile = new File(path + collectionName + ".txt");
                HashSet<Reader> readers = new HashSet<>();
                try (FileReader readerReader = new FileReader(readerFile)) {
                    char[] readerBuffer = new char[(int) readerFile.length()];
                    readerReader.read(readerBuffer);
                    String[] readerLines = new String(readerBuffer).split("\\r?\\n");
                    for (String readerString : readerLines) {
                        String[] readerInfo = readerString.split(" ");
                        Reader reader = new Reader(readerInfo[0], readerInfo[1], readerInfo[2], readerInfo[3]);
                        reader.setId(Integer.parseInt(readerInfo[4]));
                        readers.add(reader);
                    }
                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
                return readers;
            case "booktype":
                File booktypeFile = new File(path + collectionName + ".txt");
                HashSet<BookType> booktypes = new HashSet<>();
                try (FileReader booktypeReader = new FileReader(booktypeFile)) {
                    char[] booktypeBuffer = new char[(int) booktypeFile.length()];
                    booktypeReader.read(booktypeBuffer);
                    String[] booktypeLines = new String(booktypeBuffer).split("\\r?\\n");
                    for (String booktypeString : booktypeLines) {
                        String[] booktypeInfo = booktypeString.split(" ");
                        Genre genre = new Genre(booktypeInfo[1]);
                        genre.setId(Integer.parseInt(booktypeInfo[2]));
                        Author author = new Author(booktypeInfo[3]);
                        author.setId(Integer.parseInt(booktypeInfo[4]));
                        BookType bookType = new BookType(booktypeInfo[0], genre, author);
                        bookType.setId(Integer.parseInt(booktypeInfo[5]));
                        booktypes.add(bookType);
                    }
                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
                return booktypes;
            case "librarian":
                File librarianFile = new File(path + collectionName + ".txt");
                HashSet<Librarian> librarians = new HashSet<>();
                try (FileReader librarianReader = new FileReader(librarianFile)) {
                    char[] librarianBuffer = new char[(int) librarianFile.length()];
                    librarianReader.read(librarianBuffer);
                    String[] librarianLines = new String(librarianBuffer).split("\\r?\\n");
                    for (String librarianString : librarianLines) {
                        String[] librarianInfo = librarianString.split(" ");
                        Librarian librarian = new Librarian(librarianInfo[0], librarianInfo[1], librarianInfo[2], librarianInfo[3]);
                        librarian.setId(Integer.parseInt(librarianInfo[4]));
                        librarians.add(librarian);
                    }
                } catch (IOException e) {
                    LOGGER.info(e.getMessage());
                }
                return librarians;
        }
        return new HashSet<>();
    }
}
