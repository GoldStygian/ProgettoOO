package main.java.ImplementazionePostgresDAO;

import main.java.DAO.RegisterDAO;
import main.java.Database.ConnessionePostges;

import java.sql.*;

public class RegisterPostgerDAO implements RegisterDAO {

    public String RegisterUser(String Nome, String Cognome, String Genere, String Email, String Password) throws SQLException {
        String messageError="";
        if (Nome.isBlank()){
            messageError += "nome non valido<br>";
        }
        if (Cognome.isBlank()){
            messageError += "cognome non valido<br>";
        }
        if (Password.isBlank()){
            messageError += "password non valida<br>";
        }

        Connection con = new ConnessionePostges().openConnection();

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT email FROM utente WHERE email = '%s'".formatted(Email));
        if (resultSet.next()){
            messageError += "email gia esistente<br>";
        }else {

            String query = "INSERT INTO utente VALUES('%s', '%s', '%s', '%s', '%s', '%s')".formatted(Email, Nome, Cognome, Password, Genere, 0);
            PreparedStatement Pstatement = con.prepareStatement(query);
            try {
                Pstatement.executeUpdate();//ritorna il numero di righe inserite
                System.out.println("[ ] " + query);
                Pstatement.close();
            } catch (SQLException e) { // se duplicato o dominio non valido
                System.out.println(e.getMessage());
                messageError += "email errata<br>";
            }

        }

        statement.close();
        resultSet.close();
        con.close();
        return messageError;

    }

}
