package com.netcracker.edu.commands;

import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public class DeleteGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteGenre.class);
    public int parametersNumber = 2;
    public DAO dao = DAOFactory.getDAO();

    //todo ??? ????????? ?????? ????????????? ?? ???????? id ? ?????? ?????? ?????????? ???????
    //???? ?????? ??? 16
    @Override
    public int execute(String[] parameters) throws SQLException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 1;
        }
        if (!Context.getLoggedHolder().getRights()) {
            LOGGER.warn("Error: Access only for librarians.");
            return 2;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        boolean result;
        try {
            result = dao.deleteGenre(new BigInteger((parameters[1])));
        } catch (NumberFormatException e) {
            LOGGER.warn("Error: ID should be number.");
            return 6;
        }
        if (!result) {
            LOGGER.warn("Error: Unsuccessful delete.");
            return 15;
        }
        LOGGER.info("Genre successfully deleted.");
        return 0;
    }

    @Override
    public String getName() {
        return "delete_genre";
    }

    @Override
    public String getHelp() {
        return "to delete genre use " + getName() + " genre_id" + "\n"
                + "Example: delete_genre 15";
    }
}
