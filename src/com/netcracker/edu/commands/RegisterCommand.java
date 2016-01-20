package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.User;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.netcracker.edu.util.ExceptionCode.*;

/**
 * Created by FlowRyder
 */
public class RegisterCommand extends Command {
    public static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);
    public final int parametersNumber = 6;
    Pattern loginPattern = Pattern.compile("^(?=.{3,24})[a-z][a-z0-9]*[._-]?[a-z0-9]+$");
    Pattern emailPattern = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
    Pattern passwordPattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");

    @Override
    public int execute(String[] parameters)  {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return wrongParametersNumber;
        }

        Matcher loginMatcher = loginPattern.matcher(parameters[2]);
        if (!loginMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of login.");
            return invalidLogin;
        }

        Matcher emailMatcher = emailPattern.matcher(parameters[3]);
        if (!emailMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of email.");
            return invalidEmail;
        }

        Matcher passwordMatcher = passwordPattern.matcher(parameters[4]);
        if (!passwordMatcher.matches()) {
            LOGGER.warn("Error: Invalid format of password.");
            return invalidPassword;
        }
        User user;
        try {
            user = new User(parameters[1], parameters[2], parameters[3], parameters[4].toCharArray());
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Error: Name shouldn't be null or void.");
            return invalidNameValue;
        }
        if (parameters[5].equals("librarian")) {
            user.setRights(true);
        } else {
            LOGGER.warn("Error: Role should be reader or librarian.");
            return invalidRole;
        }
        if (!DAO.addUser(user)) {
            LOGGER.info("Error: unsuccessfully query. User hasn't been registered.");
            return unsuccessfullQuery;
        }
        LOGGER.info("User successfully registered.");
        return success;
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
