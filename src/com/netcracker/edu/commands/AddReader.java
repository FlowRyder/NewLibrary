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
    public Reader create() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter name:");
        String name = scanner.nextLine();
        LOGGER.info("Enter login:");
        String login = scanner.nextLine();
        LOGGER.info("Enter email:");
        String email = scanner.nextLine();
        LOGGER.info("Enter password:");
        String password = scanner.nextLine();
        return new Reader(name, login, email, password);
    }

    @Override
    public void execute() {
        MemoryDAO.getInstance().getReaders().add(create());
        LOGGER.info("Reader successfully added.");
    }

    @Override
    public String getName() {
        return "add_reader";
    }

    @Override
    public String getHelp() {
        return "to add reader use " + getName();
    }
}
