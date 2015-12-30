package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        String mod = scanner.nextLine();
        switch (mod) {
            case "console":
                console();
                break;
            case "scenario":
                scenario();
                break;
        }
    }

    public static void console() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
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
}
