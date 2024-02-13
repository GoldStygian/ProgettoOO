package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<ArrayList<String>> searchPages(String ricerca) {

        try {
            ArrayList<ArrayList<String>> DataPages = new FunzionalitPostgresDAO().SearchPage(ricerca);
            return DataPages;
        } catch (SQLException e) {
            return null;
        }

    }

}