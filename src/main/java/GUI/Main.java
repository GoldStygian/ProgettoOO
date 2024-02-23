package main.java.GUI;

import main.java.Controller.Controller;

import java.sql.SQLException;

public class Main {
    private static final Controller controller = new Controller();
    public static void main(String[] args) throws SQLException {

       MainJFrame frame = new MainJFrame("Wikipedia", 1500,700);
       frame.SetPanel(new Home(frame, controller).getPanel());
       frame.Resize(1400,700);

    }

}
//problema con posizioni a null in storicita
//controllare se in storicita vengono prese le frasi rifiutate
//login troppo lento
//cache nella storicita
//aggiustare il layout
//aggiungere cose alla home
//mettere nel model le proposte
//mettere stderr nel log
//mettere if al posto di while nei reultset con 1 return result