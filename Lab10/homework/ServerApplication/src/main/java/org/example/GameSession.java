package org.example;

import java.util.Arrays;

public class GameSession {
    private ClientThread player1;
    private ClientThread player2;
    private int[][] board1;
    private int[][] board2;
    private boolean player1Turn;
    private boolean player1Ready = false;
    private boolean player2Ready = false;

    public GameSession(ClientThread player1) {
        this.player1 = player1;
        this.board1 = new int[5][5];  // Player 1's board
        this.board2 = new int[5][5];  // Player 2's board
        this.player1Turn = true;
    }

    public boolean addPlayer(ClientThread player2) {
        if (this.player2 == null) {
            this.player2 = player2;
            player1.sendMessage("Both players joined. Place your ships using the command: place <row> <col>");
            player2.sendMessage("Both players joined. Place your ships using the command: place <row> <col>");
            return true;
        }
        return false;
    }

    public void placeShip(ClientThread player, int row, int col) {
        if (player == player1) {
            if (board1[row][col] == 0) {
                board1[row][col] = -1;  // Mark as ship
                player1Ready = true;
                player.sendMessage("Ship placed at (" + row + ", " + col + "). Waiting for the other player.");
                if (player2Ready) {
                    startGame();
                }
            } else {
                player.sendMessage("A ship is already placed there. Try again.");
            }
        } else if (player == player2) {
            if (board2[row][col] == 0) {
                board2[row][col] = -1;  // Mark as ship
                player2Ready = true;
                player.sendMessage("Ship placed at (" + row + ", " + col + "). Waiting for the other player.");
                if (player1Ready) {
                    startGame();
                }
            } else {
                player.sendMessage("A ship is already placed there. Try again.");
            }
        }
    }

    private void startGame() {
        player1.sendMessage("Game started! You are Player 1.");
        player2.sendMessage("Game started! You are Player 2.");
        player1.sendMessage("Your turn.");
        player2.sendMessage("Waiting for Player 1's move.");
    }

    public void handleMove(ClientThread player, String moveCommand) {
        String[] parts = moveCommand.split(" ");
        int row = Integer.parseInt(parts[1]);
        int col = Integer.parseInt(parts[2]);

        if (player1Turn && player == player1) {
            processMove(board2, player1, player2, row, col);
            if (!isGameOver()) {
                player1Turn = false;
                player1.sendMessage("Waiting for Player 2's move.");
                player2.sendMessage("Your turn.");
            }
        } else if (!player1Turn && player == player2) {
            processMove(board1, player2, player1, row, col);
            if (!isGameOver()) {
                player1Turn = true;
                player2.sendMessage("Waiting for Player 1's move.");
                player1.sendMessage("Your turn.");
            }
        } else {
            player.sendMessage("It's not your turn.");
        }

        if (isGameOver()) {
            if (player == player1 && isAllShipsSunk(board2)) {
                player1.sendMessage("Hit! You won!");
                player2.sendMessage("Your ship was hit at (" + row + ", " + col + "). You lost.");
            } else if (player == player2 && isAllShipsSunk(board1)) {
                player2.sendMessage("Hit! You won!");
                player1.sendMessage("Your ship was hit at (" + row + ", " + col + "). You lost.");
            }
        }
    }

    private void processMove(int[][] opponentBoard, ClientThread currentPlayer, ClientThread opponentPlayer, int row, int col) {
        if (opponentBoard[row][col] == -1) {  // There is a ship at this position
            opponentBoard[row][col] = 1;     // Mark as hit
            currentPlayer.sendMessage("Hit!");
            opponentPlayer.sendMessage("Your ship was hit at (" + row + ", " + col + ").");
        } else {
            currentPlayer.sendMessage("Miss!");
        }
    }

    private boolean isGameOver() {
        return isAllShipsSunk(board1) || isAllShipsSunk(board2);
    }

    private boolean isAllShipsSunk(int[][] board) {
        return Arrays.stream(board).flatMapToInt(Arrays::stream).noneMatch(v -> v == -1);
    }
}
