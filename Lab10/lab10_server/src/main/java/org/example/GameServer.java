package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class GameServer {
    private static final int PORT = 6666;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}
