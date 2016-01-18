package com.netcracker.edu.commands;

import com.netcracker.edu.dao.DAO;
import com.netcracker.edu.dao.DAOFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by FlowRyder
 */
public abstract class Command {
    public static DAO dao = DAOFactory.getDAO();
    public abstract int execute(String[] parameters) throws IOException, SQLException;
    public abstract String getName();
    public abstract String getHelp();
}
