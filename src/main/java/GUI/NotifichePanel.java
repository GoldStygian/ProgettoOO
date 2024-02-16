package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class NotifichePanel extends JPanel {

    private JPanel MainPanel;
    private JLabel Autore;
    private JLabel Data;
    private JLabel Modifica;
    private JLabel accettataJLabel;
    private JLabel visionataJLabel;
    private JLabel LinkJLabel;

    public NotifichePanel(MainJFrame frame, int Id_operazione, Timestamp datar, String testo, boolean accettata, boolean visionata, boolean modifica, boolean link, int link_pagina ,String Utente) {

        Autore.setText(Utente);
        Data.setText(datar.toString());
        Modifica.setText(String.valueOf(modifica));
        accettataJLabel.setText(String.valueOf(accettata));
        visionataJLabel.setText(String.valueOf(visionata));
        LinkJLabel.setText(String.valueOf(link));
        this.add(MainPanel);
        this.setBackground(frame.getColorBack());
    }


}

