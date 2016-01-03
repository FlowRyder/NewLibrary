package com.netcracker.edu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by FlowRyder on 02.01.2016.
 */
public class Client {

    public static void execute() throws IOException, ClassNotFoundException {
        Socket localhost = new Socket("localhost", 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
        PrintWriter output = new PrintWriter(localhost.getOutputStream(), true);
        BufferedReader inputSystem = new BufferedReader(new InputStreamReader(System.in));
        String client = inputSystem.readLine();
        output.println(client);
        String server = input.readLine();
        System.out.println(server);
        output.close();
        input.close();
        inputSystem.close();
        localhost.close();
    }
}
