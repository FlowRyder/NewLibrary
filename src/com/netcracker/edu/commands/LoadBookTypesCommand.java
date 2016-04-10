package com.netcracker.edu.commands;

import com.netcracker.edu.cache.Cache;

/**
 * Created by FlowRyder.
 */
public class LoadBookTypesCommand extends Command {
    @Override
    public int execute(String[] parameters) {
        Wrapper.getInstance().setResult(Cache.getInstance().getBooktypes().toString());
        return 0;
    }

    @Override
    public String getName() {
        return "load_booktypes";
    }

    @Override
    public String getHelp() {
        return "to load booktypes use load_booktypes";
    }
}
