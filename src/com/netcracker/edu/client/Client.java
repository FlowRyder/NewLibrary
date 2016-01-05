package com.netcracker.edu.client;

import com.netcracker.edu.commands.CommandEngine;
import com.netcracker.edu.connection.Server;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by FlowRyder on 02.01.2016.
 */
public class Client {
    public static final Logger LOGGER = Logger.getLogger(Server.class);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String mod = scanner.nextLine();
        switch(mod) {
            case "console":
                console();
                break;
            case "scenario":
                scenario();
                break;
        }
    }

    public static void console() throws IOException, ClassNotFoundException {
        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        BufferedReader inputSystem = new BufferedReader(new InputStreamReader(System.in));
        String client, server;
        while(true) {
            client = inputSystem.readLine();
            output.println(client);
            server = input.readLine();
            System.out.println(server);
            if(client.equals("exit")) {
                break;
            }

        }
        output.close();
        input.close();
        inputSystem.close();
        localhost.close();
    }

    public static void scenario() throws IOException, ClassNotFoundException {
        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        BufferedReader inputSystem = new BufferedReader(new InputStreamReader(System.in));
        String server;
        String[] commands = null;
        File file = new File("C:\\Users\\FlowRyder\\IdeaProjects\\Library\\src\\com\\netcracker\\edu\\data\\scenario.txt");
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            commands = new String(buffer).split("\\r?\\n");
            for (String string : commands) {
                String[] parameters = string.split(" ");
                CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        for(String client : commands) {
            output.println(client);
            server = input.readLine();
            System.out.println(server);
            if(client.equals("exit")) {
                break;
            }

        }
        output.close();
        input.close();
        inputSystem.close();
        localhost.close();
    }
}
