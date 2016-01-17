package com.netcracker.edu.commands;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public abstract class Command {
    public abstract int execute(String[] parameters) throws IOException, SQLException;
    public abstract String getName();
    public abstract String getHelp();
}
