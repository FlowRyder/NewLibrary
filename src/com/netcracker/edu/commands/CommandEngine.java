package com.netcracker.edu.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FlowRyder
 */
public final class CommandEngine {
    private static CommandEngine INSTANCE = null;
    private final Map<String, Command> commandMap;

    private CommandEngine() {
        commandMap = new HashMap<>();
        commandMap.put("add_account", new AddAccount());
        commandMap.put("add_author", new AddAuthor());
        commandMap.put("add_book", new AddBook());
        commandMap.put("add_bookType", new AddBookType());
        commandMap.put("add_genre", new AddGenre());
        commandMap.put("delete_account", new DeleteAccount());
        commandMap.put("delete_author", new DeleteAuthor());
        commandMap.put("delete_book", new DeleteBook());
        commandMap.put("delete_bookType", new DeleteBookType());
        commandMap.put("delete_genre", new DeleteGenre());
        commandMap.put("edit_account", new EditAccount());
        commandMap.put("edit_author", new EditAuthor());
        commandMap.put("edit_book", new EditBook());
        commandMap.put("edit_bookType", new EditBookType());
        commandMap.put("edit_genre", new EditGenre());
        commandMap.put("help", new HelpCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("log_in", new LogInCommand());
        commandMap.put("log_out", new LogOutCommand());
        commandMap.put("register", new RegisterCommand());
        commandMap.put("load_genres",new LoadGenresCommand());
        commandMap.put("load_authors",new LoadAuthorsCommand());
        commandMap.put("load_booktypes", new LoadBookTypesCommand());
        commandMap.put("find_by_login", new FindByLogin());
        commandMap.put("find_by_author", new FindByAuthor());
        commandMap.put("find_by_genre", new FindByGenre());
        commandMap.put("find_by_book", new FindByBook());
    }

    public static CommandEngine getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandEngine();
        }
        return INSTANCE;
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
