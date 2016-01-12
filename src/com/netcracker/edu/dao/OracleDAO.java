package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.util.ConnectionParameters;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by FlowRyder.
 */
public class OracleDAO implements DAO {
    public static final Logger LOGGER = Logger.getLogger(OracleDAO.class);
    private static OracleDAO INSTANCE;
    private Connection connection;

    private OracleDAO() {
        // temporary thing(because OracleDAO not integrated in consoleApp yet)
        String[] parametersOfConnection = ConnectionParameters.getPaprametersOfConnection();
        Locale.setDefault(Locale.US);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(parametersOfConnection[0],
                    parametersOfConnection[1], parametersOfConnection[2]);
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static synchronized OracleDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OracleDAO();
        }
        return INSTANCE;
    }

    @Override
    public void addAccount(Account account) {
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        if (author == null) {
            throw new IllegalArgumentException("Error: Author shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUTHORS(NAME,ID) VALUES (?,?)");
        try {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setLong(2, author.getId().longValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void addBook(Book book) throws SQLException {
        if (book == null) {
            throw new IllegalArgumentException("Error: Book shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BOOKS(BOOKTYPE_ID,ID) VALUES (?,?)");
        try {
            preparedStatement.setLong(1, book.getBookTypeID().longValue());
            preparedStatement.setLong(2, book.getId().longValue());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void addBookType(BookType bookType) throws SQLException {
        if (bookType == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                "BOOKTYPES(NAME,GENRE_ID,AUTHOR_ID,ID) VALUES (?,?,?,?)");
        try {
            preparedStatement.setString(1, bookType.getName());
            preparedStatement.setLong(2, bookType.getGenreID().longValue());
            preparedStatement.setLong(3, bookType.getAuthorID().longValue());
            preparedStatement.setLong(4, bookType.getId().longValue());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void addGenre(Genre genre) throws SQLException {
        if (genre == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO GENRES(NAME,ID) VALUES (?,?)");
        try {
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setLong(2, genre.getId().longValue());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void addReader(Reader reader) throws SQLException {
        if (reader == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                "READERS(NAME,LOGIN,EMAIL,PASSWORD,ID) VALUES (?,?,?,?,?)");
        try {
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getLogin());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPassword().toString());
            preparedStatement.setLong(5, reader.getId().longValue());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public void addLibrarian(Librarian librarian) throws SQLException {
        if (librarian == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                "READERS(NAME,LOGIN,EMAIL,PASSWORD,ID) VALUES (?,?,?,?,?)");
        try {
            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getLogin());
            preparedStatement.setString(3, librarian.getEmail());
            preparedStatement.setString(4, librarian.getPassword().toString());
            preparedStatement.setLong(5, librarian.getId().longValue());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    @Override
    public Account loadAccount(BigInteger id) {
        return null;
    }

    @Override
    public Author loadAuthor(BigInteger id) {
        return null;
    }

    @Override
    public Book loadBook(BigInteger id) {
        return null;
    }

    @Override
    public BookType loadBookType(BigInteger id) {
        return null;
    }

    @Override
    public Genre loadGenre(BigInteger id) {
        return null;
    }

    @Override
    public Reader loadReader(BigInteger id) {
        return null;
    }

    @Override
    public Librarian loadLibrarian(BigInteger id) {
        return null;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAuthor(Author author) {
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBookType(BookType bookType) {
        return false;
    }

    @Override
    public boolean deleteGenre(Genre genre) {
        return false;
    }

    @Override
    public boolean deleteReader(Reader reader) {
        return false;
    }

    @Override
    public boolean deleteLibrarian(Librarian librarian) {
        return false;
    }


    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void updateBookType(BookType bookType) {

    }

    @Override
    public void updateGenre(Genre genre) {

    }

    @Override
    public void updateReader(Reader reader) {

    }

    @Override
    public void updateLibrarian(Librarian librarian) {

    }

    @Override
    public User findByLogin(String login) {
        return null;
    }
}
