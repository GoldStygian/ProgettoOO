package main.java.GUI;

import main.java.Controller.Controller;
import main.java.Model.InserimentoUtente;
import main.java.Model.ModificaUtente;
import main.java.Model.Notifica;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class NotificheFrame extends JFrame {

    private JPanel MainJPanel;
    private JPanel Notifiche;
    private JPanel Divisore;


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

        try {
            controller.LoadNotifiche();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ArrayList> s = controller.GetNotifiche();
        for (int i = 0 ; i < s.get(0).size(); i++) {

            //System.out.printf(String.valueOf((Dati.get(0).get(i)).getClass()) + String.valueOf((Dati.get(1).get(i)).getClass()) + String.valueOf((Dati.get(2).get(i)).getClass())+ String.valueOf((Dati.get(3).get(i)).getClass())+ String.valueOf((Dati.get(4).get(i)).getClass())+ String.valueOf((Dati.get(5).get(i)).getClass())+ String.valueOf((Dati.get(6).get(i)).getClass())+ String.valueOf((Dati.get(7).get(i)).getClass())+ String.valueOf((Dati.get(8).get(i)).getClass())+ String.valueOf((Dati.get(9).get(i)).getClass()));
            Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)));
            //new Notifica(new InserimentoUtente((Date) Dati.get(0).get(i), (Boolean) Dati.get(1).get(i),(Boolean) Dati.get(2).get(i)));
            //System.out.println("io");

        }

        //Notifiche.add(new NotifichePanel(frame));
        /*
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Notifiche.add(new NotifichePanel(frame),gbc);
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
