package com.netcracker.edu.commands;

import com.netcracker.edu.businessobjects.User;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;

import static com.netcracker.edu.util.ExceptionCode.*;
import static com.netcracker.edu.util.ExceptionCode.success;

/**
 * Created by FlowRyder.
 */
public class FindByLogin extends Command {
        public static final Logger LOGGER = Logger.getLogger(LogInCommand.class);
        public final int parametersNumber = 2;

        @Override
        public int execute(String[] parameters)  {
            if (parameters.length != parametersNumber) {
                LOGGER.warn("Error: Wrong number of parameters.");
                return wrongParametersNumber;
            }
            User user = DAO.findByLogin(parameters[1]);
            Wrapper.getInstance().setResult(user.getId().toString());
            return success;
        }

        @Override
        public String getName() {
            return "find_by_login";
        }

        @Override
        public String getHelp() {
            return "to find by login use: " + getName() + "login";
        }
}
