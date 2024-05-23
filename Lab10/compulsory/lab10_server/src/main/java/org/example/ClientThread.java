package org.example;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("stop".equalsIgnoreCase(inputLine)) {
                    out.println("Server stopped");
                    break;
                }
                out.println("Server received the request: " + inputLine);
            }

            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port or listening for a connection");
            System.err.println(e.getMessage());
        }
    }
}
