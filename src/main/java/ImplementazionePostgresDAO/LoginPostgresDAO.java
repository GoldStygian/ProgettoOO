package main.java.ImplementazionePostgresDAO;

import main.java.DAO.LoginDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPostgresDAO implements LoginDAO {

    @Override
    public boolean Login(String email, String password) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT email, password_utente FROM utente WHERE email = '%s' AND password_utente = '%s'".formatted(email, password);
        ResultSet resultSet = statement.executeQuery(query);

        /*while (resultSet.next()) {
            System.out.println(resultSet.getString("email"));
        }*/

        // Chiusura delle risorse
        con.close();
        if (resultSet.next()){//se contiene qualcosa allora email e password combaciano
            resultSet.close();
            statement.close();
            return true;
        }else{
            resultSet.close();
            statement.close();
            return false;
        }

    }
}
