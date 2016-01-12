package com.netcracker.edu.commands;

import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder
 */
public class LogOutCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogOutCommand.class);

    @Override
    public int execute(String[] parameters) throws IOException {
        if (Context.getLoggedHolder() == null) {
            LOGGER.warn("Error: User isn't logged in.");
            return 14;
        }
        Context.removeUserFromSignedUsers();
        LOGGER.info("User successfully logged out.");
        return 0;
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
