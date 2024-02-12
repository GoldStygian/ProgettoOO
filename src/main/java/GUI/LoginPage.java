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
    private JTextField emailField;
    private JPasswordField passwordField;
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

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controller.Login(emailField.getText(), passwordField.getText())){

                }
                else{
                    //metti la scritta
                }
            }
        });


    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
