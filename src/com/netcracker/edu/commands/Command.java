package com.netcracker.edu.commands;

import java.io.IOException;

/**
 * Created by FlowRyder
 */
public abstract class Command {
    public abstract int execute(String[] parameters) throws IOException;
    public abstract String getName();
    public abstract String getHelp();
}
