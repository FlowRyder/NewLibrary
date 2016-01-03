package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import com.netcracker.edu.util.Load;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by FlowRyder on 03.01.2016.
 */
public class LogInCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(Load.class);

    @Override
    public void execute(String[] parameters) throws IOException {
        if(parameters.length != 3) {
            LOGGER.info("Error: wrong number of parameters.");
        }
        for(Reader reader : FileDAO.getInstance().getReaders()) {
            if(parameters[1].equals(reader.getLogin()) && parameters[2].equals(reader.getPassword())) {
                Context.addReader(reader);
                return;
            }
        }
        for(Librarian librarian : FileDAO.getInstance().getLibrarians()) {
            if(parameters[1].equals(librarian.getLogin()) && parameters[2].equals(librarian.getPassword())) {
                Context.addLibrarian(librarian);
                return;
            }
        }
        LOGGER.info("Error: Incorrect login or password");
    }

    @Override
    public String getName() {
        return "log_in";
    }

    @Override
    public String getHelp() {
        return "to log in use enter" + getName() + " login password";
    }
}
