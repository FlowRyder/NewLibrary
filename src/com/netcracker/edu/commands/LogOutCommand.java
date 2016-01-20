package com.netcracker.edu.commands;

import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.notLoggedInToLogOut;
import static com.netcracker.edu.util.ExceptionCode.success;

/**
 * Created by FlowRyder
 */
public class LogOutCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogOutCommand.class);

    @Override
    public int execute(String[] parameters) {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return notLoggedInToLogOut;
        }
        Context.removeUserFromSignedUsers();
        LOGGER.info("User successfully logged out.");
        return success;
    }

    @Override
    public String getName() {
        return "log_out";
    }

    @Override
    public String getHelp() {
        return "to use log out " + getName();
    }
}
