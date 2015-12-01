package com.netcracker.edu.commands;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;


/**
 * Created by FlowRyder on 29.11.2015.
 */
public class ExecuteConsoleCommand {
    public static final Logger LOGGER = Logger.getLogger(ExecuteConsoleCommand.class);
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            LOGGER.info("Enter command:");
            String value = scanner.nextLine();
            if("exit".equals(value)) {
                return;
            }
            CommandEngine.getInstance().getCommandMap().get(value).execute();
        }
    }
}
