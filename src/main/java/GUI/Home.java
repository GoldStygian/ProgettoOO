package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home {

    private JPanel MainPanel;
    private JButton registerbutton;
    private JButton loginbutton;
    private JPanel ToolBar;
    private JPanel ButtonPanel;

    public Home(MainJFrame frame, Controller controller) {

        loginbutton.setFont(frame.getFontToolBar());

        ButtonPanel.setBackground(frame.getColorToolBar());

        ToolBar.setBackground(frame.getColorToolBar());

        loginbutton.setBackground(frame.getColorToolBar());

        loginbutton.setBorderPainted(false);

        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(new LoginPage(frame, MainPanel,controller).getPanel(), MainPanel);
                loginbutton.setBackground(frame.getColorToolBar());
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
                loginbutton.setBackground(frame.getColorToolBar());
            }
        });
    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
