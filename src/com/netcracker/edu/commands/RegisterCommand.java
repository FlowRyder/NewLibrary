package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.Librarian;
import com.netcracker.edu.businessobjects.Reader;
import com.netcracker.edu.dao.FileDAO;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by FlowRyder
 */
public class RegisterCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);
    public int parametersNumber = 6;
    Pattern loginPatter = Pattern.compile("^(?=.{3,24})[a-z][a-z0-9]*[._-]?[a-z0-9]+$");
    Pattern emailPattern = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
    Pattern passwordPattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");

    @Override
    public int execute(String[] parameters) throws IOException {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return 3;
        }

        Matcher loginMatcher = loginPatter.matcher(parameters[2]);
        if (!loginMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of login.");
            return 7;
        }

        Matcher emailMatcher = emailPattern.matcher(parameters[3]);
        if (!emailMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of email.");
            return 8;
        }

        Matcher passwordMatcher = passwordPattern.matcher(parameters[4]);
        if (!passwordMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of password.");
            return 9;
        }
        if (parameters[5].equals("reader")) {
            Reader reader;
            try {
                reader = new Reader(parameters[1], parameters[2], parameters[3], parameters[4].toCharArray());
            } catch (IllegalArgumentException e) {
                LOGGER.warn("Error: Name shouldn't be null or void.");
                return 4;
            }
            FileDAO.getInstance().addReader(reader);
        } else if (parameters[5].equals("librarian")) {
            Librarian librarian;
            try {
                librarian = new Librarian(parameters[1], parameters[2], parameters[3], parameters[4].toCharArray());
            } catch (IllegalArgumentException e) {
                LOGGER.warn("Error: Name shouldn't be null or void.");
                return 4;
            }
            FileDAO.getInstance().addLibrarian(librarian);
        } else {
            LOGGER.warn("Error: Role should be reader or librarian.");
            return 10;
        }
        LOGGER.info("User successfully registered.");
        return 0;
    }

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public String getHelp() {
        return "to register use " + getName() + " name login email password role" + "\n"
                + "Example: register Petya petya89 smirnovpetya@gmail.com read12book34 reader";
    }
}
