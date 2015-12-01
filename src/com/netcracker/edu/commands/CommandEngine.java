package com.netcracker.edu.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FlowRyder on 29.11.2015.
 */
public final class CommandEngine {
    private static CommandEngine INSTANCE = new CommandEngine();
    private Map<String, Command> commandMap;

    private CommandEngine() {
        commandMap = new HashMap<>();
        commandMap.put("add_account", new AddAccount());
        commandMap.put("add_author", new AddAuthor());
        commandMap.put("add_book", new AddBook());
        commandMap.put("add_bookType", new AddBookType());
        commandMap.put("add_genre", new AddGenre());
        commandMap.put("add_reader", new AddReader());
        commandMap.put("delete_account", new DeleteAccount());
        commandMap.put("delete_author", new DeleteAuthor());
        commandMap.put("delete_book", new DeleteBook());
        commandMap.put("delete_bookType", new DeleteBookType());
        commandMap.put("delete_genre", new DeleteGenre());
        commandMap.put("delete_reader", new DeleteReader());
        commandMap.put("edit_account", new EditAccount());
        commandMap.put("edit_author", new EditAuthor());
        commandMap.put("edit_book", new EditBook());
        commandMap.put("edit_bookType", new EditBookType());
        commandMap.put("edit_genre", new EditGenre());
        commandMap.put("edit_reader", new EditReader());
        commandMap.put("help", new HelpCommand());
    }

    public static CommandEngine getInstance() {
        return INSTANCE;
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
