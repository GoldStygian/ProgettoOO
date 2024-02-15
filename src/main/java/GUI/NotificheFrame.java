package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.MissingFormatArgumentException;

public class NotificheFrame extends JFrame {

    private JPanel MainJPanel;


    public NotificheFrame(String Nome, MainJFrame frame, Controller controller) {

        super(Nome);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
        this.add(MainJPanel);
        this.setSize(500, 700);
        this.setIconImage(frame.getIconImage());
        this.setResizable(false);
        //this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);


    }


    private void createUIComponents() {

    }
}
