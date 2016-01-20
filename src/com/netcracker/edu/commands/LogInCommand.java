package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.User;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;

import static com.netcracker.edu.util.ExceptionCode.*;

/**
 * Created by FlowRyder
 */
public class LogInCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
    public final int parametersNumber = 3;

    @Override
    public int execute(String[] parameters)  {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return wrongParametersNumber;
        }
        User user = DAO.findByLogin(parameters[1]);
        /*WARNING! Different warning message for wrong login/password
        is unsafe, this is temporary usage for troubleshooting.*/
        if (user == null) {
            LOGGER.warn("Error: There is no user with such login.");
            return noSuchLogin;
        }
        if (!Arrays.equals(user.getPassword(), parameters[2].toCharArray())) {
            LOGGER.warn("Error: Wrong password.");
            return noSuchPassword;
        }
        try {
            Context.setLoggedUser(user);
        } catch (AccessDeniedException e) {
            LOGGER.warn("Error: User already logged in.");
            return alreadyLoggedIn;
        }
        LOGGER.info("User successfully logged in.");
        return success;
    }

    @Override
    public String getName() {
        return "log_in";
    }

    @Override
    public String getHelp() {
        return "to log in use " + getName() + " login password" + "\n"
                + "Example: petya89 read12book34";
    }
}
