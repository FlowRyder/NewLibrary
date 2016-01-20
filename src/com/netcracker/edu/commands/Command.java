package com.netcracker.edu.commands;

import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;
import com.netcracker.edu.session.Context;
import com.netcracker.edu.util.ExceptionCode;
import org.apache.log4j.Logger;

/**
 * Created by FlowRyder
 */
public abstract class Command {
    public static final Logger LOGGER = Logger.getLogger(AddGenre.class);
    public static final DAO DAO = DAOFactory.getDAO();
    public final int parametersNumber = 1;

    public int checkLibrarian(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return ExceptionCode.notLoggedIn;
        }
        if (!Context.getLoggedHolder().getRights()) {
            LOGGER.warn("Error: Access only for librarians.");
            return ExceptionCode.hasNotRights;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return ExceptionCode.wrongParametersNumber;
        }
        return ExceptionCode.success;
    }

    public int checkReader(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return ExceptionCode.notLoggedIn;
        }
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return ExceptionCode.wrongParametersNumber;
        }
        return ExceptionCode.success;
    }

    public abstract int execute(String[] parameters);

    public abstract String getName();

    public abstract String getHelp();
}
