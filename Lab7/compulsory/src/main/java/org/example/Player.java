package org.example;

import java.util.ArrayList;
import java.util.List;

class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Token> tokens = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            if (game.isMyTurn(this)) {
                Token token = game.pickToken();
                if (token != null) {
                    tokens.add(token);
                    System.out.println(name + " picked token: (" + token.getNum1() + ", " + token.getNum2() + ")");
                    // Think about how to make a sequence
                } else {
                    System.out.println(name + " couldn't pick token, bag is empty.");
                    stop();
                }
            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getName() {
        return name;
    }
}
