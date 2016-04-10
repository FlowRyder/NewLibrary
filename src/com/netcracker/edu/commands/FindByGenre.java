package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import static com.netcracker.edu.util.ExceptionCode.success;
import static com.netcracker.edu.util.ExceptionCode.wrongParametersNumber;

/**
 * Created by FlowRyder.
 */
public class FindByGenre extends Command {
    public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
    public final int parametersNumber = 2;

    @Override
    public int execute(String[] parameters)  {
        if (parameters.length != parametersNumber) {
            LOGGER.warn("Error: Wrong number of parameters.");
            return wrongParametersNumber;
        }
        String genreID = DAO.findByGenre(parameters[1]);
        Wrapper.getInstance().setResult(genreID);
        return success;
    }

    @Override
    public String getName() {
        return "find_by_genre";
    }

    @Override
    public String getHelp() {
        return "to find by genre use: " + getName() + "genreName";
    }
}
