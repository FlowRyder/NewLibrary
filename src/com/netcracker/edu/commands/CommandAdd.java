package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.IDObject;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public abstract class CommandAdd extends Command {
    public abstract IDObject create(String[] parameters);
}
