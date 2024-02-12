package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Home {

    private boolean bool = true;
    private JPanel MainPanel;
    private JButton registerbutton;
    private JButton loginbutton;
    private JPanel ToolBar;
    private JPanel ButtonPanel;
    private JLabel Icon;
    private JPanel BarraDiRicerca;
    private JTextField SerchBar;
    private JLabel IconaLente;
    private JLabel NameApp;
    private JPanel BarIcon;
    private JPanel SerchBorder;

    public Home(MainJFrame frame, Controller controller) {



        loginbutton.setFont(frame.getFontToolBar());

        loginbutton.setBackground(frame.getColorToolBar());

        loginbutton.setBorderPainted(false);

        loginbutton.setForeground(Color.BLACK);

        ButtonPanel.setBackground(frame.getColorToolBar());

        ToolBar.setBackground(frame.getColorToolBar());

        Image ResizeImage = frame.getIcon().getImage().getScaledInstance(65,65, java.awt.Image.SCALE_SMOOTH);

        Icon.setIcon(new ImageIcon(ResizeImage));

        BarraDiRicerca.setBackground(frame.getColorToolBar());

        registerbutton.setFont(frame.getFontToolBar());

        registerbutton.setBackground(frame.getColorToolBar());

        registerbutton.setBorderPainted(false);

        registerbutton.setForeground(Color.BLACK);

        ImageIcon IconLente = new ImageIcon("C:\\Users\\filix\\IdeaProjects\\ProgettoOO\\src\\main\\resources\\magnifying-glass.png");

        Image ResizeImage2 = IconLente.getImage().getScaledInstance(20,20, java.awt.Image.SCALE_SMOOTH);

        IconaLente.setIcon(new ImageIcon(ResizeImage2));

        MainPanel.setBackground(new Color(255, 211, 206));

        //SerchBar.setText(" ".repeat(120));

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        //SerchBar.setBorder(new LineBorder(Color.BLACK,1));
        SerchBar.setBorder(null);

        SerchBar.setPreferredSize(new Dimension(500,25));

        SerchBar.setBackground(new Color(199, 111, 91));

        SerchBorder.setBorder(new LineBorder(Color.BLACK,2));

        SerchBorder.setFont(frame.getFontToolBar());


        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(new LoginPage(frame, MainPanel,controller).getPanel(), MainPanel);
                loginbutton.setBackground(frame.getColorToolBar());
                SerchBar.setText(" ".repeat(120));
                bool = true;

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

        registerbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                registerbutton.setBackground(new Color(199, 111, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                registerbutton.setBackground(frame.getColorToolBar());
            }

        });

        registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(new RegisterPage(frame, MainPanel,controller).getPanel(), MainPanel);
                loginbutton.setBackground(frame.getColorToolBar());
            }
        });


        frame.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                if(!bool){
                    SerchBar.setText(" ".repeat(120));
                    bool = true;
                }
            }
        });

        SerchBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(bool){
                    bool = false;
                    SerchBar.setText("");
                }

            }
        });
    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
