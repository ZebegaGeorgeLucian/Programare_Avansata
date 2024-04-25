package org.example;

import java.util.*;

class Player implements Runnable {
    private String name;
    private Game game;
    private List<Token> tokens = new ArrayList<>();
    private Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (game.isRunning()) {
            Token token = game.pickToken(this);
            if (token != null) {
                tokens.add(token);
                adjacencyList.computeIfAbsent(token.getNum1(), k -> new HashSet<>()).add(token.getNum2());
                System.out.println(name + " drew token: " + token);
            }
        }
        System.out.println(name + " largest sequence length: " + findLargestCycle());
    }

    private int findLargestCycle() {
        Set<Integer> allNodes = new HashSet<>(adjacencyList.keySet());
        int maxLength = 0;
        for (Integer node : allNodes) {
            if (adjacencyList.containsKey(node)) {
                maxLength = Math.max(maxLength, dfsFindCycle(node, node, new HashSet<>(), 0));
            }
        }
        return maxLength;
    }

    private int dfsFindCycle(int start, int current, Set<Integer> visited, int pathLength) {
        int maxPath = 0;
        visited.add(current);
        Set<Integer> neighbors = adjacencyList.getOrDefault(current, Collections.emptySet());
        for (Integer neighbor : neighbors) {
            if (neighbor.equals(start) && pathLength > 0) {  // Ensure it's a cycle
                maxPath = Math.max(maxPath, pathLength + 1); // Complete the cycle
            } else if (!visited.contains(neighbor)) {
                maxPath = Math.max(maxPath, dfsFindCycle(start, neighbor, new HashSet<>(visited), pathLength + 1));
            }
        }
        return maxPath;
    }
}
