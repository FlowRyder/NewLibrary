package com.netcracker.edu.commands;

import com.netcracker.edu.cache.Cache;

/**
 * Created by FlowRyder.
 */
public class LoadAuthorsCommand extends Command {
    @Override
    public int execute(String[] parameters) {
        Wrapper.getInstance().setResult(Cache.getInstance().getAuthors().toString());
        return 0;
    }

    @Override
    public String getName() {
        return "load_authors";
    }

    @Override
    public String getHelp() {
        return "to load author use load_authors";
    }
}
