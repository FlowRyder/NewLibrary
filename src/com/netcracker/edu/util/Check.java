package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.dao.MemoryDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.util.Iterator;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Check {
    public static final Logger LOGGER = Logger.getLogger(Check.class);

    public static void isNullOrVoid(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value is null or void.");
        }
    }

    public static void isNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Value is null.");
        }
    }

    public static boolean access() {
        if (Context.getLoggedHolder() == null) {
            LOGGER.info("Error: User doesn't logged in. ");
            return true;
        }
        return false;
    }

    public static boolean isReader() {
        if (Context.getLoggedHolder() instanceof Reader) {
            return true;
        }
        return false;
    }

    public static boolean containBookType(Genre genre, Author author, String name) {
        Iterator<BookType> bookTypeIterator = MemoryDAO.getInstance().getBookTypes().iterator();
        while (bookTypeIterator.hasNext()) {
            BookType bookType = bookTypeIterator.next();
            if (bookType.getName().equals(name) && bookType.getGenre().equals(genre) && bookType.getAuthor().equals(author)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containGenre(String name) {
        Iterator<Genre> genreIterator = MemoryDAO.getInstance().getGenres().iterator();
        while (genreIterator.hasNext()) {
            if (genreIterator.next().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containAuthor(String name) {
        Iterator<Author> authorIterator = MemoryDAO.getInstance().getAuthors().iterator();
        while (authorIterator.hasNext()) {
            if (authorIterator.next().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}