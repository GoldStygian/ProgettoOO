package main.java.GUI;

import javax.swing.*;

public class MainJFrame extends JFrame {


    public MainJFrame(String Nome){
        super(Nome);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 200);
    }

    public void SetNewPanel(JPanel NewMainPanel, JPanel OldMainPanel){
        this.remove(OldMainPanel);
        this.setContentPane(NewMainPanel);
        this.revalidate();
        this.repaint();
    }

    public void SetPanel(JPanel NewMainPanel){
        this.setContentPane(NewMainPanel);
    }
}
