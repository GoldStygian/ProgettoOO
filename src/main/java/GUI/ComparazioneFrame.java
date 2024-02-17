package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;

public class ComparazioneFrame extends JFrame{
    private JPanel MainJPanel;
    private JButton button1;
    private JButton button2;

    public  ComparazioneFrame(String Nome, MainJFrame frame, Controller controller, int id_operazione){
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
