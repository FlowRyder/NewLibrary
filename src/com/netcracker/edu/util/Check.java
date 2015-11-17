package com.netcracker.edu.util;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.businessobjects.NamedObject;
import com.netcracker.edu.dao.MemoryDAO;

import java.util.Iterator;

/**
 * Created by FlowRyder on 13.11.2015.
 */
public class Check {
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