package com.netcracker.edu.connection;

import com.netcracker.edu.commands.CommandEngine;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder on 05.01.2016.
 */
public class ServerThread implements Runnable {
    public static final Logger LOGGER = Logger.getLogger(Server.class);
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String inputSource;
            LOGGER.info("Enter command:");
            while ((inputSource = input.readLine()) != null) {
                try {
                    String[] parameters = inputSource.split(" ");
                    CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
                    output.println("Well Done!");
                } catch (Exception e) {
                    LOGGER.info(e.getMessage());
                }
            }
            socket.close();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
