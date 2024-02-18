package main.java.ImplementazionePostgresDAO;

import main.java.DAO.LoginDAO;
import main.java.Model.Autore;
import main.java.Model.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginPostgresDAO implements LoginDAO {

    @Override
    public ArrayList<String> Login(String email, String password) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM utente WHERE email = '%s' AND password_utente = '%s'".formatted(email, password);
        ResultSet resultSet = statement.executeQuery(query);

        // Chiusura delle risorse
        con.close();

        ArrayList<String> Contenuto = null;

        if (resultSet.next()){//se contiene qualcosa allora email e password combaciano

            Contenuto = new ArrayList<String>();

            Contenuto.add(resultSet.getString("autore"));
            Contenuto.add(resultSet.getString("email"));
            Contenuto.add(resultSet.getString("password_utente"));
            Contenuto.add(resultSet.getString("nome"));
            Contenuto.add(resultSet.getString("cognome"));
            Contenuto.add(resultSet.getString("genere"));


        }

        resultSet.close();
        statement.close();
        return Contenuto;

    }
}
