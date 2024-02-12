package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JPanel MainPanel;
    private JButton Backbutton;
    private JPanel ToolBar;
    private JPanel LoginBox;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel Logo;
    private JButton loginButton;


    public LoginPage(MainJFrame frame, JPanel OldPanel, Controller controller) {



        Logo.setIcon(frame.getIcon());
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
