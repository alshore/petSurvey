package com.andrew;/*
 Created by Andrew on 10/25/2016.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class petGui extends JFrame {
    private JCheckBox fishCheckBox;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JButton exitButton;
    private JPanel mainPanel;
    private JLabel resultString;

    private boolean dog, cat, fish;

    petGui() {
        setContentPane(mainPanel);
        pack();
        setSize(500, 400);
        setVisible(true);

        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(petGui.this, "Are you sure you want to quit?",
                        "Quit?", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults() {
        String hasCat = cat ? "a cat" : "no cat";
        String hasDog = dog ? "a dog" : "no dog";
        String hasFish = fish ? "a fish" : "no fish";

        String results = "You have " + hasCat + ", " + hasDog + ", and " + hasFish;
        resultString.setText(results);
    }
}
