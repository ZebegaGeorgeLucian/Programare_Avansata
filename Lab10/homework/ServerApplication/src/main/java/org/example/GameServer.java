package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private static final int PORT = 6666;
    private static List<GameSession> gameSessions = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Game Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (Exception e) {
            System.err.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized static void createGame(ClientThread clientThread) {
        GameSession gameSession = new GameSession(clientThread);
        gameSessions.add(gameSession);
        clientThread.setGameSession(gameSession);
    }

    public synchronized static void joinGame(ClientThread clientThread) {
        for (GameSession session : gameSessions) {
            if (session.addPlayer(clientThread)) {
                clientThread.setGameSession(session);
                return;
            }
        }
        clientThread.sendMessage("No available game to join. Try creating a game.");
    }
}
