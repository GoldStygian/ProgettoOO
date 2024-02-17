package main.java.GUI;

import javax.swing.*;

public class ComparazioneFrame extends JFrame{
    private JPanel MainJPanel;

    public  ComparazioneFrame(String Nome, MainJFrame frame){
        super(Nome);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.add(MainJPanel);
        this.setSize(1500, 700);
        this.setIconImage(frame.getIconImage());
        this.setResizable(false);
    }
}
