package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by FlowRyder on 30.11.2015.
 */
public class HelpCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(HelpCommand.class);
    @Override
    public void execute(String[] parameters) throws IOException {
        Collection<Command> helpCollection = CommandEngine.getInstance().getCommandMap().values();
        for (Command command : helpCollection) {
            LOGGER.info(command.getHelp());
        }
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
