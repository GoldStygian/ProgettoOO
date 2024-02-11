package main.java.GUI;

import javax.swing.*;

public class MainJFrame extends JFrame {

    public MainJFrame(String Nome){
        super(Nome);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(700, 800);
    }

    public void SetNewPanel(JPanel NewMainPanel, JPanel OldMainPanel){
        this.remove(OldMainPanel);
        this.add(NewMainPanel);
        this.revalidate();
        this.repaint();
    }

    public void SetPanel(JPanel NewMainPanel){
        this.add(NewMainPanel);
    }
}
