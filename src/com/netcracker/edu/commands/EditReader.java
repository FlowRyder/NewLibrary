package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
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
public class EditReader extends CommandEdit {
    public static final Logger LOGGER = Logger.getLogger(EditGenre.class);

    @Override
    public Reader edit(String[] parameters) {
        Reader reader = (Reader) FileDAO.getInstance().choose(FileDAO.getInstance().getReaders(), Integer.parseInt(parameters[1]));
        FileDAO.getInstance().getReaders().remove(reader);
        reader.setName(parameters[2]);
        reader.setEmail(parameters[3]);
        reader.setLogin(parameters[4]);
        reader.setPassword(parameters[5]);
        return reader;
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 6) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getReaders().add(edit(parameters));
        LOGGER.info("Reader successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_reader";
    }

    @Override
    public String getHelp() {
        return "to edit reader use " + getName() + " reader_id + name + email + login + password";
    }
}
