package com.connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardFrame extends JPanel {

    private JTextField player1NameField;
    private JTextField player2NameField;
    private JTextField timerField;
    private JButton backToMenuButton;
    private JButton restartGameButton;
    private JPanel gridPanel;
    private JButton[][] grid;

    private Player.Players currentPlayer;
    private Player.Players player1;
    private Player.Players player2;

    public BoardFrame(Player.Players player1, Player.Players player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        setLayout(new BorderLayout());

        JPanel namesAndTimerPanel = new JPanel(new BorderLayout());

        JPanel player1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        player1NameField = new JTextField(player1.getName(), 10);
        player1NameField.setEditable(false);
        player1Panel.add(player1NameField);

        JPanel player2Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        player2NameField = new JTextField(player2.getName(), 10);
        player2NameField.setEditable(false);
        player2Panel.add(player2NameField);

        JPanel timerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timerField = new JTextField("00:00", 10);
        timerField.setEditable(false);
        timerPanel.add(timerField);

        namesAndTimerPanel.add(player1Panel, BorderLayout.WEST);
        namesAndTimerPanel.add(player2Panel, BorderLayout.EAST);
        namesAndTimerPanel.add(timerPanel, BorderLayout.CENTER);

        gridPanel = new JPanel(new GridLayout(6, 7, 2, 2));
        grid = new JButton[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                grid[row][col] = new JButton();
                grid[row][col].setPreferredSize(new Dimension(50, 50));
                grid[row][col].setBackground(Color.WHITE);
                grid[row][col].addActionListener(new GridButtonListener(col));
                gridPanel.add(grid[row][col]);
            }
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        backToMenuButton = new JButton("Back to Menu");
        bottomPanel.add(backToMenuButton);

        restartGameButton = new JButton("Restart Game");
        bottomPanel.add(restartGameButton);

        add(namesAndTimerPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private class GridButtonListener implements ActionListener {
        private int col;

        public GridButtonListener(int col) {
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            currentPlayer.placeDisk(grid, col);
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    public JTextField getTimerField() {
        return timerField;
    }

    public JButton getBackToMenuButton() {
        return backToMenuButton;
    }

    public JButton getRestartGameButton() {
        return restartGameButton;
    }

    public JButton[][] getGrid() {
        return grid;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Player.Players player1 = new Player.Players("Player 1", Color.RED, 0);      //Dummy player1
            Player.Players player2 = new Player.Players("Player 2", Color.YELLOW, 0);	//Dummy player2

            JFrame frame = new JFrame("Connect 4 Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);

            BoardFrame board = new BoardFrame(player1, player2);
            frame.add(board);

            frame.setVisible(true);
        });
    }
}

