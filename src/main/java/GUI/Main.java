package main.java.GUI;

import main.java.Controller.Controller;
import main.java.ImplementazionePostgresDAO.LoginPostgresDAO;

public class Main {

    private static MainJFrame frame;
    private static Controller controller;

    public static void main(String[] args){

       frame = new MainJFrame("Home");
       frame.SetPanel(new Home(frame, controller).getPanel());


    }

}