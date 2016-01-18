package com.netcracker.edu.client;

import com.netcracker.edu.connection.Server;
import com.netcracker.edu.util.FileLocation;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by FlowRyder.
 */
public class Client {
    public static final Logger LOGGER = Logger.getLogger(Server.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
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

    public static void console() throws IOException, ClassNotFoundException {
        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        BufferedReader inputSystem = new BufferedReader(new InputStreamReader(System.in));
        String client, server;
        while (true) {
            client = inputSystem.readLine();
            output.println(client);
            server = input.readLine();
            System.out.println(server);
            if (client.equals("exit")) {
                output.close();
                input.close();
                inputSystem.close();
                localhost.close();
                System.exit(0);
            }
        }
    }

    public static void scenario() throws IOException, ClassNotFoundException {
        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        String[] commands = null;
        File file = new File(FileLocation.getScenario());
        try (FileReader fileReader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            fileReader.read(buffer);
            commands = new String(buffer).split("\\r?\\n");
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        while (true) {
            for (String client : commands) {
                String[] parameters = client.split(":");
                output.println(parameters[0]);
                int result = Integer.parseInt(input.readLine());
                if (result == Integer.parseInt(parameters[1])) {
                    LOGGER.info("Command successful done.");
                } else {
                    LOGGER.info("Command end with different code.");
                }
            }
        }
        // Unreachable code, because app tests until error.
        /*output.close();
        input.close();
        inputSystem.close();
        localhost.close();*/
    }
}
