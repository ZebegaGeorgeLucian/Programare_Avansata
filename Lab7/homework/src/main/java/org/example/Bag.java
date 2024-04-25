package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Bag {
    private List<Token> tokens;

    public Bag(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.add(new Token(i, j));
                }
            }
        }
    }

    public synchronized Token drawToken() {
        if (!tokens.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(tokens.size());
            return tokens.remove(randomIndex);
        }
        return null;
    }

    public boolean isEmpty() {
        return tokens.isEmpty();
    }
}
