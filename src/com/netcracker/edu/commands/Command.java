package com.netcracker.edu.commands;

import java.io.IOException;

/**
 * Created by FlowRyder on 14.11.2015.
 */
public interface Command {
    public void execute() throws IOException;

    public String getName();

    public String getHelp();
}
