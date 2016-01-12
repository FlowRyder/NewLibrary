package com.netcracker.edu.commands;

import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.util.IDGenerator;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder
 */
public class ExitCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(ExitCommand.class);

    @Override
    public int execute(String[] parameters) throws IOException {
        IDGenerator.getInstance().saveID();
        FileDAO.getInstance().saveFileStorage();
        return 0;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getHelp() {
        return "to exit use " + getName();
    }
}
