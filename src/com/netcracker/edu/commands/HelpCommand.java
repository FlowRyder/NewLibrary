package com.netcracker.edu.commands;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by FlowRyder on 30.11.2015.
 */
public class HelpCommand extends Command {
    @Override
    public void execute() throws IOException {
        Collection<Command> helpCollection = CommandEngine.getInstance().getCommandMap().values();
        for (Command command : helpCollection) {
            System.out.println(command.getHelp());
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
