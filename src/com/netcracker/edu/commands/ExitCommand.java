package com.netcracker.edu.commands;

import com.netcracker.edu.util.Save;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder on 30.12.2015.
 */
public class ExitCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(ExitCommand.class);

    @Override
    public void execute(String[] parameters) throws IOException {
        Save.saveCollection("account");
        Save.saveCollection("author");
        Save.saveCollection("book");
        Save.saveCollection("booktype");
        Save.saveCollection("genre");
        Save.saveCollection("reader");
        Save.saveCollection("librarian");
        System.exit(0);
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
