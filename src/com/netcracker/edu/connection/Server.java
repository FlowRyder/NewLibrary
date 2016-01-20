package com.netcracker.edu.connection;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by FlowRyder
 */
public class Server {
    public static final Logger LOGGER = Logger.getLogger(Server.class);

    public static void execute() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            return;
        }
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
                return;
            }
            new Thread(new ServerThread(socket)).start();
        }

    }
}
