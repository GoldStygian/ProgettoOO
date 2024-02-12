package main.java.Controller;

import main.java.ImplementazionePostgresDAO.LoginPostgresDAO;

public class Controller {

    public boolean Login(String email, String password) {

        try {
            return LoginPostgresDAO.Login("email", "password");
        } catch (Exception ex) {
            System.out.println("ciao\n");
        }

    }


}