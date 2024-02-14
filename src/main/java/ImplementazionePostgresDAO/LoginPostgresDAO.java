package main.java.ImplementazionePostgresDAO;

import main.java.DAO.LoginDAO;
import main.java.Model.Autore;
import main.java.Model.Utente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPostgresDAO implements LoginDAO {

    @Override
    public Utente Login(String email, String password) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM utente WHERE email = '%s' AND password_utente = '%s'".formatted(email, password);
        ResultSet resultSet = statement.executeQuery(query);

        // Chiusura delle risorse
        con.close();
        if (resultSet.next()){//se contiene qualcosa allora email e password combaciano
            if (resultSet.getBoolean("autore")==true){
                new Autore(
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("nome"),
                        resultSet.getString("cognome"),
                        resultSet.getString("genere").charAt(0)
                );
            }else {
                new Utente(
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("nome"),
                        resultSet.getString("cognome"),
                        resultSet.getString("genere").charAt(0)
                );
            }
            resultSet.close();
            statement.close();
        }else{
            resultSet.close();
            statement.close();
            return null;
        }

    }
}
