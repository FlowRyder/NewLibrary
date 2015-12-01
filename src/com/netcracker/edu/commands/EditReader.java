package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Reader;
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
    public Reader edit() {
        LOGGER.info("Choose reader:");
        Reader reader = (Reader) MemoryDAO.getInstance().choose(MemoryDAO.getInstance().getReaders());
        MemoryDAO.getInstance().getReaders().remove(reader);
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter name:");
        reader.setName(scanner.nextLine());
        LOGGER.info("Enter email:");
        reader.setEmail(scanner.nextLine());
        LOGGER.info("Enter login:");
        reader.setLogin(scanner.nextLine());
        LOGGER.info("Enter password:");
        reader.setPassword(scanner.nextLine());
        return reader;
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getReaders().add(edit());
        LOGGER.info("Reader successfully edited.");
    }

    @Override
    public String getName() {
        return "edit_reader";
    }

    @Override
    public String getHelp() {
        return "to edit reader use " + getName();
    }
}
