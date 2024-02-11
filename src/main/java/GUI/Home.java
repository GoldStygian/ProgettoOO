package main.java.GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    protected JPanel MainPanel;
    private JButton button1;

    public Home(MainJFrame frame) {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(new LoginPage(frame, MainPanel).getPanel(), MainPanel);

            }
        });
    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
