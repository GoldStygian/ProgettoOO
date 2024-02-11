package main.java.GUI;

import javax.swing.*;

public class MainJFrame extends JFrame {

    public MainJFrame(String Nome){
        super(Nome);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 300);
    }
}
