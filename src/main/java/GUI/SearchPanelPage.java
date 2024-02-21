package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPanelPage extends JPanel {
    private JButton LinkToPage;
    private JLabel Intestazione;
    private JPanel MainPanel;
    private JPanel Link;

    public SearchPanelPage(MainJFrame frame, Controller controller, JPanel OldPanel, String Titolo, String Id_pagina, String NomeAutore, String Ultima_modifica) {
        this.add(MainPanel);
        LinkToPage.setActionCommand(Id_pagina);
        Intestazione.setText(NomeAutore + " " + Ultima_modifica);
        LinkToPage.setText(Titolo);
        this.setBorder(null);
        Link.setBackground(frame.getColorBack());
        Link.setBorder(null);
        this.setBackground(frame.getColorBack());

        LinkToPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int buttonHidden = Integer.parseInt(((JButton) e.getSource()).getActionCommand());
                System.out.println("Hai premuto il link con id: " + e.getActionCommand());
                frame.SetNewPanel(new WikiPage(frame, OldPanel, controller, buttonHidden).getPanel(), MainPanel);
            }
        });


    }


}
