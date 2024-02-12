package main.java.Controller;

import main.java.ImplementazionePostgresDAO.LoginPostgresDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public boolean Login(String email, String password) {

        try {
            boolean login =  new LoginPostgresDAO().Login(email, password);
            return  login;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public ResultSet FindPages(String stringaRicerca){

        ResultSet pagine = null;
        return pagine;
    }


}