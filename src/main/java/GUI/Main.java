package main.java.GUI;

import main.java.Controller.Controller;

public class Main {

    private static MainJFrame frame;
    private static Controller controller = new Controller();

    public static void main(String[] args){

       frame = new MainJFrame("Wikipedia", 1500,700);
       frame.SetPanel(new Home(frame, controller).getPanel());
       frame.Resize(1400,700);

       //eliminare il metoto chiudi connessione

    }

}