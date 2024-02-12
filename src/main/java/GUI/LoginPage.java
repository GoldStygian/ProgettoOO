package main.java.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JPanel MainPanel;
    private JButton Backbutton;


    public LoginPage(MainJFrame frame, JPanel OldPanel) {

        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);

            }
        });

        //controller.login(email, passowrd) //dalla gui


    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
