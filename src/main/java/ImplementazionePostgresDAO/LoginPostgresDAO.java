package main.java.ImplementazionePostgresDAO;

import main.java.DAO.LoginDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPostgresDAO implements LoginDAO {

    //@Override
    public boolean Login(String email, String password) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT email, password FROM utente WHERE email = '%s' AND password = '%s'".formatted(email, password);
        System.out.println(query);
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // Esempio: stampa dei valori delle colonne
            System.out.println("Colonna1: " + resultSet.getString("colonna1"));
            System.out.println("Colonna2: " + resultSet.getString("colonna2"));
            // E così via per le altre colonne
        }

        // Chiusura delle risorse
        resultSet.close();
        statement.close();
        con.close();
        return false;
    }
}
