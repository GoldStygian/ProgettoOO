package main.java.GUI;

import main.java.Database.Connessione;

import javax.swing.*;

public class Main {
    private JPanel panel1;
    private JButton accountButton;
    private JTextField textField1;
    private JLabel cercaLabel;

    public static void main(String[] args){

        System.out.println("[ ] start");

        JFrame frame = new JFrame("Wiki");
        frame.setContentPane(new Main().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        ImageIcon logo = new ImageIcon("C:\\Users\\prora\\Desktop\\ProgettoOO\\ProgettoOO\\src\\static\\logo2.png"); //aggiustare
        frame.setIconImage(logo.getImage());
        frame.setSize(400, 300); // sempre dopo frame.pack()
        frame.setVisible(true);

        Connessione c = new Connessione();

    }

}
