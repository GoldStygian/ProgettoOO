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
    private JPanel LogoBox;
    private JPanel DivisoreImgEmail;
    private JPanel EmailBox;
    private JPanel PassBox;
    private JPanel LoginButtonBox;

    public LoginPage(MainJFrame frame, JPanel OldPanel, Controller controller) {

        GuiPresetComponet t = new GuiPresetComponet(frame);

        t.ToolBarButton(Backbutton);

        ToolBar.setBackground(frame.getColorToolBar());

        MainPanel.setBackground(frame.getColorBack());

        t.SetIcon(Logo, new ImageIcon(t.ResizeIcon(150,150,frame.getIcon())));

        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65,65,frame.getIcon())));

        t.SetIcon(IconBack, new ImageIcon(t.ResizeIcon(20,20,new ImageIcon("C:\\Users\\filix\\IdeaProjects\\ProgettoOO\\src\\main\\resources\\back.png"))));

        errorMessage.setVisible(false);

        LoginBox.setBackground(frame.getColorBack());

        DivisioreToolBar.setBackground(frame.getColorBack());

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        LogoBox.setBackground(frame.getColorBack());

        DivisoreImgEmail.setBackground(frame.getColorBack());

        //emailField.setPreferredSize(new Dimension(1000,200));

        LoginButtonBox.setBackground(frame.getColorBack());
        EmailBox.setBackground(frame.getColorBack());
        PassBox.setBackground(frame.getColorBack());


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
