package com.netcracker.edu.commands;

import com.netcracker.edu.util.IDGenerator;
import org.apache.log4j.Logger;
import static com.netcracker.edu.util.ExceptionCode.*;

/**
 * Created by FlowRyder
 */
public class ExitCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(ExitCommand.class);

    @Override
    public int execute(String[] parameters) {
        IDGenerator.getInstance().saveID();
        return success;
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
