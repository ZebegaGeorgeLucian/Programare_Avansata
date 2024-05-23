package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GameSession gameSession;

    public ClientThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("stop".equalsIgnoreCase(inputLine)) {
                    out.println("Server stopped");
                    break;
                } else if ("create game".equalsIgnoreCase(inputLine)) {
                    GameServer.createGame(this);
                    out.println("Game created. Waiting for another player to join...");
                } else if ("join game".equalsIgnoreCase(inputLine)) {
                    GameServer.joinGame(this);
                } else if (inputLine.startsWith("place")) {
                    if (gameSession != null) {
                        String[] parts = inputLine.split(" ");
                        int row = Integer.parseInt(parts[1]);
                        int col = Integer.parseInt(parts[2]);
                        gameSession.placeShip(this, row, col);
                    } else {
                        out.println("You are not in a game.");
                    }
                } else if (inputLine.startsWith("move")) {
                    if (gameSession != null) {
                        gameSession.handleMove(this, inputLine);
                    } else {
                        out.println("You are not in a game.");
                    }
                } else {
                    out.println("Unknown command.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error in Client Thread: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
