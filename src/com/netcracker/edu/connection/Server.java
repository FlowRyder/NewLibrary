package com.netcracker.edu.connection;

import com.netcracker.edu.commands.CommandEngine;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by FlowRyder on 05.01.2016.
 */
public class Server {
    public static final Logger LOGGER = Logger.getLogger(Server.class);
    public static void execute() throws IOException{
        ServerSocket serverSocket = new ServerSocket(4444);
        while(true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }

    }
}
