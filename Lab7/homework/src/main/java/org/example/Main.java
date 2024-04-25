package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(8);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        Thread gameThread = new Thread(() -> game.play());
        Timekeeper timekeeper = new Timekeeper(game, 60000); // 60 seconds time limit
        Thread timekeeperThread = new Thread(timekeeper);
        timekeeperThread.setDaemon(true);

        gameThread.start();
        timekeeperThread.start();
    }
}
