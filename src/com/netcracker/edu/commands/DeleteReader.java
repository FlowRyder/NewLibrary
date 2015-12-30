package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteReader extends Command {
    public static final Logger LOGGER = Logger.getLogger(DeleteReader.class);

    @Override
    public void execute(String[] parameters) throws IOException {
        if (parameters.length != 2) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        FileDAO.getInstance().getReaders().remove(FileDAO.getInstance().choose(FileDAO.getInstance().getReaders(), Integer.parseInt(parameters[1])));
        LOGGER.info("Reader successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_reader";
    }

    @Override
    public String getHelp() {
        return "to delete reader use " + getName() + " reader_id";
    }
}
