package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;

public class NotifichePanel extends JPanel {

    private JFrame AccettazioneFrame;
    private JPanel MainPanel;
    private JLabel Autore;
    private JLabel Data;
    private JLabel Modifica;
    private JLabel accettataJLabel;
    private JLabel visionataJLabel;
    private JLabel LinkJLabel;

    public NotifichePanel(MainJFrame frame, Controller controller , int Id_operazione, Timestamp datar, String testo, boolean accettata, boolean visionata, boolean modifica, boolean link, int link_pagina ,String Utente) {

        GuiPresetComponet t = new GuiPresetComponet(frame);

        Autore.setText(Utente);
        Data.setText(datar.toString());
        Modifica.setText(String.valueOf(modifica));
        accettataJLabel.setText(String.valueOf(accettata));
        visionataJLabel.setText(String.valueOf(visionata));
        LinkJLabel.setText(String.valueOf(link));
        MainPanel.setBackground(frame.getColorToolBar());
        MainPanel.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(MainPanel);
        this.setBackground(frame.getColorBack());
        MainPanel.setForeground(Color.BLACK);
        t.LabelSetTextBlack(Autore);
        t.LabelSetTextBlack(Data);
        t.LabelSetTextBlack(Modifica);
        t.LabelSetTextBlack(accettataJLabel);
        t.LabelSetTextBlack(visionataJLabel);
        t.LabelSetTextBlack(LinkJLabel);



        MainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                MainPanel.setBackground(frame.getColorBack());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                MainPanel.setBackground(frame.getColorToolBar());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AccettazioneFrame = new ComparazioneFrame("Comparazione", frame, controller, Id_operazione);
                controller.LoadConfronto(Id_operazione);

            }
        });
    }


}

