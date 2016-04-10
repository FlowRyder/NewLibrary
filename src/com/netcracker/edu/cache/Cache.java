package com.netcracker.edu.cache;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.businessobjects.BookType;
import com.netcracker.edu.businessobjects.Genre;
import com.netcracker.edu.dao.OracleDAO;
import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * Created by FlowRyder.
 */
public class Cache {
    public static final Logger LOGGER = Logger.getLogger(Cache.class);
    private static Cache INSTANCE = null;
    private static Collection<Genre> genres;
    private static Collection<Author> authors;
    private static Collection<BookType> booktypes;

    private Cache() {
        genres = OracleDAO.getInstance().loadGenres();
        authors = OracleDAO.getInstance().loadAuthors();
        booktypes = OracleDAO.getInstance().loadBookTypes();

    }

    public static Cache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Cache();
        }
        return INSTANCE;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public Collection<BookType> getBooktypes() {
        return booktypes;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

}
