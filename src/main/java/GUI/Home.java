package main.java.GUI;

import main.java.ImplementazionePostgresDAO.LoginPostgresDAO;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Home {

    private JPanel MainPanel;
    private JButton registerbutton;
    private JButton loginbutton;
    private JPanel ToolBar;
    private JPanel ButtonPanel;

    public Home(MainJFrame frame) {

        loginbutton.setFont(frame.getFont());
        ButtonPanel.setBackground(new Color(128,71,57));

        ToolBar.setBackground(new Color(128,71,57));

        loginbutton.setBackground(new Color(128,71,57));

        loginbutton.setBorderPainted(false);


        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(new LoginPage(frame, MainPanel).getPanel(), MainPanel);
                loginbutton.setBackground(new Color(128,71,57));

            }
        });

        loginbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginbutton.setBackground(new Color(199, 111, 91));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginbutton.setBackground(new Color(128,71,57));
            }
        });
    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
