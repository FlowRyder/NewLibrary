package com.netcracker.edu.commands;

import org.apache.log4j.Logger;
import static com.netcracker.edu.util.ExceptionCode.*;
import java.util.Collection;

/**
 * Created by FlowRyder
 */
public class HelpCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(HelpCommand.class);

    @Override
    public int execute(String[] parameters) {
        Collection<Command> helpCollection = CommandEngine.getInstance().getCommandMap().values();
        for (Command command : helpCollection) {
            LOGGER.info(command.getHelp());
        }
        return success;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "to see help use " + getName();
    }
}
