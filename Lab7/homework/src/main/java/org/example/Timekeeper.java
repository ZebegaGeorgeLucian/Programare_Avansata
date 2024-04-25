package org.example;

class Timekeeper implements Runnable {
    private final Game game;
    private final long startTime;
    private final long timeLimit;

    public Timekeeper(Game game, long timeLimit) {
        this.game = game;
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (System.currentTimeMillis() - startTime < timeLimit) {
            try {
                Thread.sleep(1000); // Sleep for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time limit exceeded. Stopping the game.");
        game.stopGame();
    }
}
