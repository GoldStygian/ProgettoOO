package main.java.GUI;

import main.java.Controller.Controller;

import java.sql.SQLException;


public class Main {

    private static MainJFrame frame;
    private static final Controller controller = new Controller();

    public static void main(String[] args) throws SQLException {

       frame = new MainJFrame("Wikipedia", 1500,700);
       frame.SetPanel(new Home(frame, controller).getPanel());
       frame.Resize(1400,700);

    }

}
//id nell'arry DataPages /nimuovere o no
//eliminare il metoto chiudi connessione
//mettere stderr nel log