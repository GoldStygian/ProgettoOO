package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static MainJFrame frame;
    private static Controller controller = new Controller();

    public static void main(String[] args){

       frame = new MainJFrame("Wikipedia", 1500,700);
       frame.SetPanel(new Home(frame, controller).getPanel());
       frame.Resize(1400,700); //perche 2 volte?

        //test
        JFrame frame2 = new JFrame("Sfondo del Panel");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 200);

        // Creazione di un pannello
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i=1; i<=4; i++){
            JLabel label = new JLabel("Esempio di aggiunta di elementi a un pannello");
            JButton button = new JButton("Clicca qui!");
            panel.add(label);
            panel.add(button);
        }

        frame2.add(panel);
        frame2.setVisible(true);


        //controller.SearchPages("");
        //
    }

}
//eliminare il metoto chiudi connessione