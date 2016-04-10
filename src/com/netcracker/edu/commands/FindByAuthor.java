package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.User;
import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.success;
import static com.netcracker.edu.util.ExceptionCode.wrongParametersNumber;

/**
 * Created by FlowRyder.
 */
public class FindByAuthor extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters)  {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return wrongParametersNumber;
        }
        String authorID = DAO.findByAuthor(parameters[1]);
        Wrapper.getInstance().setResult(authorID);
        return success;
    }

    @Override
    public String getName() {
        return "find_by_author";
    }

    @Override
    public String getHelp() {
        return "to find by author use: " + getName() + "authorName";
    }
}

