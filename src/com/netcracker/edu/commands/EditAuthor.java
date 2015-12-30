package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Author;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class EditAuthor extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditAuthor.class);

    @Override
    public Author edit(String[] parameters) {
        Author author = (Author) FileDAO.getInstance().choose(FileDAO.getInstance().getAuthors(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getAuthors().remove(author);
        author.setName(parameters[2]);
        return author;
    }

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 3) {
            LOGGER.info("Wrong number of parameters");
            return;
        }
        FileDAO.getInstance().getAuthors().add(edit(parameters));
        LOGGER.info("Author successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_author";
    }

    @Override
    public String getHelp() {
        return "to edit author use " + getName() + " author_id + author_name";
    }
}
