package com.netcracker.edu.commands;

import com.netcracker.edu.connection.Server;
import com.netcracker.edu.dao.FileDAO;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Created by FlowRyder on 29.11.2015.
 */
public class ExecuteConsoleCommand {
    public static final Logger LOGGER = Logger.getLogger(ExecuteConsoleCommand.class);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("To use console app enter console");
        LOGGER.info("To use scenario enter scenario");
        LOGGER.info("To use server enter server");
        String mod = scanner.nextLine();
        switch (mod) {
            case "console":
                console();
                break;
            case "scenario":
                scenario();
                break;
            case "server":
                server();
        }
    }

    public static void console() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            FileDAO.getInstance().show();
            LOGGER.info(Context.getLoggedHolder().toString());
            LOGGER.info("Enter command:");
            String value = scanner.nextLine();
            String[] parameters = value.split(" ");
            CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
        }
    }

    public static void scenario() {
        File file = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\scenario.txt");
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            String[] commands = new String(buffer).split("\\r?\\n");
            for (String string : commands) {
                String[] parameters = string.split(" ");
                CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static void server() throws IOException {
        Server.execute();
    }
}
