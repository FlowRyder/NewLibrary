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

    public static void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }

    }
}
