package org.example;

import java.util.ArrayList;
import java.util.List;

class Game {
    private final Bag bag;
    private final List<Player> players;
    private int currentPlayerIndex = 0;
    private boolean running = true;

    public Game(int n) {
        bag = new Bag(n);
        players = new ArrayList<>();
    }

    public synchronized Token pickToken(Player player) {
        while (!isMyTurn(player)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Token token = bag.drawToken();
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        notifyAll(); // Notify other threads it's their turn
        return token;
    }

    public synchronized boolean isMyTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        players.forEach(player -> new Thread(player).start());
    }

    public boolean isRunning() {
        return running && !bag.isEmpty();
    }

    public void stopGame() {
        running = false;
    }
}
