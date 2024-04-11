package org.example.lab6_compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sticks {
    private List<ThickStick> thickSticks;

    public Sticks() {
        this.thickSticks = new ArrayList<>();
    }

    public void makeThickSides(int width, int height) {
        Random random = new Random();
        thickSticks.clear();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boolean top = random.nextBoolean();
                boolean right = random.nextBoolean();
                boolean bottom = random.nextBoolean();
                boolean left = random.nextBoolean();

                if (top) {
                    thickSticks.add(new ThickStick(i, j, i + 1, j));
                }
                if (right) {
                    thickSticks.add(new ThickStick(i + 1, j, i + 1, j + 1));
                }
                if (bottom) {
                    thickSticks.add(new ThickStick(i, j + 1, i + 1, j + 1));
                }
                if (left) {
                    thickSticks.add(new ThickStick(i, j, i, j + 1));
                }
            }
        }
    }

    public List<ThickStick> getThickSticks() {
        return thickSticks;
    }
}
