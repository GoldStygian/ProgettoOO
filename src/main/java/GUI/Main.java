package main.java.GUI;

import main.java.Controller.Controller;

public class Main {

    private static MainJFrame frame;
    private static Controller controller = new Controller();

    public static void main(String[] args){

       frame = new MainJFrame("Wikipedia");
       frame.SetPanel(new Home(frame, controller).getPanel());

       //eliminare il metoto chiudi connessione
        // tornare indietro dopo login true
        //mostrare messaggio se login false

    }

}