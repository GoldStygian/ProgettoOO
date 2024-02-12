package main.java.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JPanel MainPanel;
    private JButton Backbutton;

    //private final MainJFrame frame;
    //private JPanel OldPanel;

    public LoginPage(MainJFrame frame, JPanel OldPanel) {
        //this.frame = frame;
        //this.OldPanel=OldPanel;

        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);

            }
        });

    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
