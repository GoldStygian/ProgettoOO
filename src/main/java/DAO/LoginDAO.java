package main.java.DAO;

import main.java.Model.Utente;

import java.sql.SQLException;

public interface LoginDAO {

    public Utente Login(String email, String password) throws SQLException;

}
