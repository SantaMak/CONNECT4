package com.connect4;

import javax.swing.*;
import java.awt.*;

public class Player {
    private String name;
    private Color color;
    private int score;

    public Player(String name, Color color, int score) {
        this.name = name;
        this.color = color;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void placeDisk(JButton[][] grid, int col) {
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][col].getBackground().equals(Color.WHITE)) {
                grid[row][col].setBackground(color);
                break;
            }
        }
    }

    public static class Players extends Player {
        public Players(String name, Color color, int score) {
            super(name, color, score);
        }
    }
}


