package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.User;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by FlowRyder
 */
public class LogInCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
    public int parametersNumber = 3;

    @Override
    public int execute(String[] parameters) throws IOException, SQLException {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }
        User user = dao.findByLogin(parameters[1]);
        /*WARNING! Different warning message for wrong login/password
        is unsafe, this is temporary usage for troubleshooting.*/
        if (user == null) {
            LOGGER.warn("Error: There is no user with such login.");
            return 12;
        }
        if (!Arrays.equals(user.getPassword(), parameters[2].toCharArray())) {
            LOGGER.warn("Error: Wrong password.");
            return 13;
        }
        if (Context.getActiveUsers().contains(user)) {
            LOGGER.warn("Error: User already logged in.");
            return 11;
        }
        Context.setLoggedUser(user);
        LOGGER.info("User successfully logged in.");
        return 0;
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
