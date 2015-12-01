package com.netcracker.edu.commands;

import java.io.IOException;

/**
 * Created by FlowRyder on 14.11.2015.
 */
public abstract class Command {
    public abstract void execute() throws IOException;
    public abstract String getName();
    public abstract String getHelp();
}
