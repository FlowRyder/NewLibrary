package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.MemoryDAO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by FlowRyder on 17.11.2015.
 */
public class DeleteReader extends CommandDelete {
    public static final Logger LOGGER = Logger.getLogger(DeleteReader.class);

    @Override
    public Reader choose() {
        LOGGER.info("Choose reader:");
        return (Reader) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getReaders());
    }

    @Override
    public void execute() throws IOException {
        MemoryDAO.getInstance().getReaders().remove(choose());
        LOGGER.info("Reader successfully deleted.");
    }

    @Override
    public String getName() {
        return "delete_reader";
    }

    @Override
    public String getHelp() {
        return "to delete reader use " + getName();
    }
}
