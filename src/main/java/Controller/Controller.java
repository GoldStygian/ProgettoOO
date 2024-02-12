package main.java.Controller;

import main.java.ImplementazionePostgresDAO.LoginPostgresDAO;

import java.sql.SQLException;

public class Controller {

    public boolean Login(String email, String password) {

        try {
            boolean login =  new LoginPostgresDAO().Login(email, password);
            System.out.println("esito: "+login); //to del
            return  login;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }


}