package com.netcracker.edu.dao;

import com.netcracker.edu.businessobjects.*;
import com.netcracker.edu.util.ConnectionPool;
import com.netcracker.edu.util.JDBCHandler;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by FlowRyder.
 */
@SuppressWarnings("all")
public class OracleDAO implements DAO {
    public static final Logger LOGGER = Logger.getLogger(OracleDAO.class);
    private static OracleDAO INSTANCE = new OracleDAO();

    static {
        Locale.setDefault(Locale.US);
    }

    public static synchronized OracleDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Error: Account shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement
                    ("INSERT INTO ACCOUNTS(STATUS,ISSUE_DATE,RETURN_DATE,ID,READER_ID,BOOK_ID) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setDate(2, account.getIssueDate());
            preparedStatement.setDate(3, account.getReturnDate());
            preparedStatement.setInt(4, account.getId().intValue());
            preparedStatement.setInt(5, account.getReaderID().intValue());
            preparedStatement.setInt(6, account.getBookID().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean addAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Error: Author shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO AUTHORS(NAME,ID) VALUES (?,?)");
            preparedStatement.setString(1, author.getName());
            preparedStatement.setInt(2, author.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Error: Book shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("INSERT INTO BOOKS(ID, BOOKTYPE_ID) VALUES (?,?)");
            preparedStatement.setLong(1, book.getId().longValue());
            preparedStatement.setLong(2, book.getBookTypeID().longValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean addBookType(BookType bookType) {
        if (bookType == null) {
            throw new IllegalArgumentException("Error: Book type shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "BOOKTYPES(NAME,ID,AUTHOR_ID,GENRE_ID) VALUES (?,?,?,?)");
            preparedStatement.setString(1, bookType.getName());
            preparedStatement.setLong(2, bookType.getId().longValue());
            preparedStatement.setLong(3, bookType.getAuthorID().longValue());
            preparedStatement.setLong(4, bookType.getGenreID().longValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean addGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("INSERT INTO GENRES(NAME,ID) VALUES (?,?)");
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setInt(2, genre.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Error: User shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "USERS(NAME,LOGIN,EMAIL,PASSWORD,ID,RIGHTS) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, new String(user.getPassword()));
            preparedStatement.setInt(5, user.getId().intValue());
            if (user.getRights()) {
                preparedStatement.setInt(6, 1);
            } else {
                preparedStatement.setInt(6, 0);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteAccount(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("UPDATE ACCOUNTS SET STATUS = ? WHERE ID = ?");
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, id.intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteAuthor(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("DELETE AUTHORS WHERE ID = ?");
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteBook(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("DELETE BOOKS WHERE ID = ?");
            preparedStatement.setInt(1, id.intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteBookType(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("DELETE BOOKTYPES WHERE ID = ?");
            preparedStatement.setInt(1, id.intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteGenre(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("DELETE GENRES WHERE ID = ?");
            preparedStatement.setInt(1, id.intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean deleteUser(BigInteger id) {
        if (id == null) {
            throw new IllegalArgumentException("Error: ID shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement
                    = connection.prepareStatement("DELETE USERS WHERE ID = ?");
            preparedStatement.setInt(1, id.intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Error: User shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE USERS SET ISSUE_DATE = ?," +
                    " RETURN_DATE = ?, READER_ID = ?, BOOK_ID = ?, WHERE ID = ?");
            preparedStatement.setDate(1, account.getIssueDate());
            preparedStatement.setDate(2, account.getReturnDate());
            preparedStatement.setInt(3, account.getReaderID().intValue());
            preparedStatement.setInt(4, account.getBookID().intValue());
            preparedStatement.setInt(5, account.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Error: Author shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("UPDATE AUTHORS SET NAME = ? WHERE ID = ?");
            preparedStatement.setString(1, author.getName());
            preparedStatement.setInt(2, author.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Error: Book shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("UPDATE BOOKS SET BOOKTYPE_ID = ? WHERE ID = ?");
            preparedStatement.setInt(1, book.getBookTypeID().intValue());
            preparedStatement.setInt(2, book.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }

        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateBookType(BookType bookType) {
        if (bookType == null) {
            throw new IllegalArgumentException("Error: Book type shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("UPDATE BOOKTYPES SET GENRE_ID = ?, AUTHOR_ID = ? WHERE ID = ?");
            preparedStatement.setInt(1, bookType.getGenreID().intValue());
            preparedStatement.setInt(2, bookType.getAuthorID().intValue());
            preparedStatement.setInt(3, bookType.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Error: Genre shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("UPDATE GENRES SET NAME = ? WHERE ID = ?");
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setInt(2, genre.getId().intValue());
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Error: User shouldn't be null");
        }
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE USERS SET NAME = ?, LOGIN = ?," +
                    "EMAIL = ?, PASSWORD = ?, RIGHTS = ?, WHERE ID = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, new String(user.getPassword()));
            preparedStatement.setInt(6, user.getId().intValue());
            if (user.getRights()) {
                preparedStatement.setInt(5, 1);
            } else {
                preparedStatement.setInt(5, 0);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
        return JDBCHandler.execute(preparedStatement, connection);
    }

    @Override
    public User findByLogin(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Error: Login shouldn't be null");
        }
        ResultSet resultSet = null;
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("SELECT NAME, LOGIN, EMAIL, PASSWORD, ID, RIGHTS " +
                            "FROM USERS WHERE LOGIN = ?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4).toCharArray());
                user.setId(BigInteger.valueOf(resultSet.getInt(5)));
                if (resultSet.getInt(6) == 1) {
                    user.setRights(true);
                }
                return user;
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
            return null;
        } finally {
            ConnectionPool.releaseConnection(connection);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        return null;
    }
}
