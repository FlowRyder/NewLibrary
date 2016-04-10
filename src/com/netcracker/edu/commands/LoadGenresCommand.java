package com.netcracker.edu.commands;

import com.netcracker.edu.cache.Cache;

/**
 * Created by FlowRyder.
 */
public class LoadGenresCommand extends Command {
    @Override
    public int execute(String[] parameters) {
        Wrapper.getInstance().setResult(Cache.getInstance().getGenres().toString());
        System.out.println(Cache.getInstance().getGenres().toString());
        return 0;
    }

    @Override
    public String getName() {
        return "load_genres";
    }

    @Override
    public String getHelp() {
        return "to load genre use load_genres";
    }
}
