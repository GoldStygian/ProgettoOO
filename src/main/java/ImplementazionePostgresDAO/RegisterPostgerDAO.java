package main.java.ImplementazionePostgresDAO;

import main.java.DAO.RegisterDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterPostgerDAO implements RegisterDAO {

    public int RegisterUser(String Nome, String Cognome, String Genere, String Email, String Password) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT email FROM utente WHERE email = '%s'".formatted(Email));
        if (resultSet.next()){
            return -4; //gia esiste quell'email
        }

        try{
            String query="INSERT INTO utente VALUES('%S', '%s', '%s', '%S', '%s', '%s')".formatted(Email, Nome, Cognome, Password, Genere, 0);
            ResultSet resultSet2 = statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -5; //email non valida
        }

        return 0;
    }

}
