package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
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
    private JLabel errorMessage;
    private JPanel GoBack;
    private JPanel IconBox;
    private JLabel Icon;
    private JLabel NameApp;
    private JLabel IconBack;
    private JPanel DivisioreToolBar;

    public LoginPage(MainJFrame frame, JPanel OldPanel, Controller controller) {

        ImageIcon Logo_img = frame.getIcon();

        Image ResizeImage2 = Logo_img.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);

        Logo.setIcon(new ImageIcon(ResizeImage2));

        ToolBar.setBackground(frame.getColorToolBar());

        MainPanel.setBackground(frame.getColorBack());

        Backbutton.setFont(frame.getFontToolBar());

        Backbutton.setBackground(frame.getColorToolBar());

        Backbutton.setBorderPainted(false);

        Backbutton.setForeground(Color.BLACK);

        errorMessage.setVisible(false);

        LoginBox.setBackground(frame.getColorBack());

        DivisioreToolBar.setBackground(frame.getColorBack());

        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                frame.Resize(1400,700);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controller.Login(emailField.getText(), passwordField.getText())){
                    frame.SetNewPanel(OldPanel, MainPanel);
                }
                else{
                    errorMessage.setVisible(true);
                }
            }
        });


    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
