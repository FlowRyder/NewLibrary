package com.netcracker.edu.commands;

import com.netcracker.edu.connection.Server;
import com.netcracker.edu.util.FileLocation;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Created by FlowRyder
 */
public class ExecuteConsoleCommand {
    public static final Logger LOGGER = Logger.getLogger(ExecuteConsoleCommand.class);

    public static void main(String[] args) throws IOException, SQLException {
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

    public static void console() throws IOException, SQLException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            LOGGER.info("Enter command:");
            String value = scanner.nextLine();
            String[] parameters = value.split(" ");
            CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
            if (parameters[0].equals("exit")) {
                System.exit(0);
            }
        }
    }

    public static void scenario() throws SQLException {
        File file = new File(FileLocation.getScenario());
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            String[] commands = new String(buffer).split("\\r?\\n");
            for (String string : commands) {
                String[] parameters = string.split(":");
                String[] commandParameters = parameters[0].split(" ");
                int result = Integer.parseInt(parameters[1]);
                if (result ==
                        CommandEngine.getInstance().getCommandMap().get(commandParameters[0]).execute(commandParameters)) {
                    LOGGER.info("Command successful done.");
                } else {
                    LOGGER.info("Command end with different code.");
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void server() throws IOException {
        Server.execute();
    }
}
