package org.example;

import java.util.ArrayList;
import java.util.List;

class Game {
    private final Bag bag;
    private final List<Player> players;
    private int currentPlayerIndex;

    public Game(int n) {
        bag = new Bag(n);
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public synchronized boolean isMyTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex;
    }

    public synchronized Token pickToken() {
        Token token = bag.drawToken();
        if (token != null) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        return token;
    }
}