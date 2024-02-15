package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.MissingFormatArgumentException;

public class NotificheFrame extends JFrame {

    private JPanel MainJPanel;


    public NotificheFrame(String Nome, MainJFrame frame, Controller controller) {

        super(Nome);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
        this.add(MainJPanel);
        this.setSize(500, 700);
        this.setIconImage(frame.getIconImage());
        this.setResizable(false);
        //this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        MainJPanel.setBackground(frame.getColorBack());


        /*
       GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        MainJPanel.add(new NotifichePanel(frame),gbc);
        */

    }


}
