package com.connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player {
    public static class Players {
        private String name;
        private String color;

        public Players(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Players{name='" + name + "', color='" + color + "'}";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlayerSelectionFrame().setVisible(true));
    }
}

class PlayerSelectionFrame extends JFrame {
    private JTextField player1NameField;
    private JComboBox<String> player1ColorComboBox;
    private JTextField player2NameField;
    private JComboBox<String> player2ColorComboBox;

    public PlayerSelectionFrame() {
        setTitle("Player Selection");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel player1NameLabel = new JLabel("Player 1 Name:");
        player1NameField = new JTextField(10);
        JLabel player1ColorLabel = new JLabel("Player 1 Color:");
        player1ColorComboBox = new JComboBox<>(new String[]{"Red", "Yellow", "Green", "Blue"});

        JLabel player2NameLabel = new JLabel("Player 2 Name:");
        player2NameField = new JTextField(10);
        JLabel player2ColorLabel = new JLabel("Player 2 Color:");
        player2ColorComboBox = new JComboBox<>(new String[]{"Red", "Yellow", "Green", "Blue"});

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(player1NameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(player1NameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(player1ColorLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(player1ColorComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(player2NameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(player2NameField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(player2ColorLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(player2ColorComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(submitButton, gbc);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String player1Name = player1NameField.getText();
            String player1Color = (String) player1ColorComboBox.getSelectedItem();
            String player2Name = player2NameField.getText();
            String player2Color = (String) player2ColorComboBox.getSelectedItem();

            if (player1Name.equalsIgnoreCase(player2Name)) {
                JOptionPane.showMessageDialog(PlayerSelectionFrame.this, "Player 2 must choose a different name than Player 1.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (player1Color.equalsIgnoreCase(player2Color)) {
                JOptionPane.showMessageDialog(PlayerSelectionFrame.this, "Player 2 must choose a different color than Player 1.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Player.Players player1 = new Player.Players(player1Name, player1Color);
            Player.Players player2 = new Player.Players(player2Name, player2Color);

            System.out.println(player1);
            System.out.println(player2);
        }
    }
}


