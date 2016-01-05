package com.netcracker.edu.commands;

import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder on 03.01.2016.
 */
public class LogOutCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogOutCommand.class);
    @Override
    public void execute(String[] parameters) throws IOException {
        Context.removeUserFromSignedUsers();
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
