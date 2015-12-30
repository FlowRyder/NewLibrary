package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by FlowRyder on 25.11.2015.
 */
public class AddReader extends CommandAdd {
    public static final Logger LOGGER = Logger.getLogger(AddReader.class);

    @Override
    public Reader create(String[] parameters) {
        return new Reader(parameters[1], parameters[2], parameters[3], parameters[4]);
    }

    @Override
    public void execute(String[] parameters) {
        if (parameters.length != 5) {
            LOGGER.info("Wrong number of parameters.");
            return;
        }
        MemoryDAO.getInstance().getReaders().add(create(parameters));
        LOGGER.info("Reader successfully added.");
    }

    @Override
    public String getName() {
        return "add_reader";
    }

    @Override
    public String getHelp() {
        return "to add reader use " + getName() + " name + login + email + password";
    }
}
