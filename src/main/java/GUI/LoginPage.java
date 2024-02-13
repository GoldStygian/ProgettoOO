package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JPanel InternalBox;

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

        Backbutton.setBorder(null);

        Image ResizeImage = frame.getIcon().getImage().getScaledInstance(65,65, java.awt.Image.SCALE_SMOOTH);

        Icon.setIcon(new ImageIcon(ResizeImage));

        errorMessage.setVisible(false);

        LoginBox.setBackground(frame.getColorBack());

        DivisioreToolBar.setBackground(frame.getColorBack());

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        ResizeImage  = (new ImageIcon("src\\main\\resources\\back.png")).getImage().getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH);

        IconBack.setIcon(new ImageIcon(ResizeImage));

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

        Backbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Backbutton.setBackground(new Color(199, 111, 91));
                InternalBox.setBackground(new Color(199, 111, 91));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Backbutton.setBackground(frame.getColorToolBar());
                InternalBox.setBackground(frame.getColorToolBar());

            }
        });


        InternalBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                InternalBox.setBackground(new Color(199, 111, 91));
                Backbutton.setBackground(new Color(199, 111, 91));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                InternalBox.setBackground(frame.getColorToolBar());
                Backbutton.setBackground(frame.getColorToolBar());
            }
        });


    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
