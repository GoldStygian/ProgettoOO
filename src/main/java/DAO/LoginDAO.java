package main.java.DAO;

import main.java.Model.Utente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginDAO {

    public ArrayList<String> Login(String email, String password) throws SQLException;

}
