package com.netcracker.edu.connection;

import com.netcracker.edu.cache.Cache;
import com.netcracker.edu.commands.CommandEngine;
import com.netcracker.edu.commands.Wrapper;
import com.netcracker.edu.session.Context;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder
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
                    LOGGER.info("Such parameters:");
                    for(String string : parameters) {
                        LOGGER.info(string);
                    }
                    int result = CommandEngine.getInstance().getCommandMap().get(parameters[0]).execute(parameters);
                    LOGGER.info("Such result: " + Wrapper.getInstance().getResult());
                    output.println(Wrapper.getInstance().getResult());
                } catch (Exception e) {
                    LOGGER.error(e.getClass());
                    e.printStackTrace();
                }
            }
            socket.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
