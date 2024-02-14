package main.java.ImplementazionePostgresDAO;

import main.java.DAO.RegisterDAO;

import java.sql.*;

public class RegisterPostgerDAO implements RegisterDAO {

    public String RegisterUser(String Nome, String Cognome, String Genere, String Email, String Password) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT email FROM utente WHERE email = '%s'".formatted(Email));
        if (resultSet.next()){
            return "email gia esistente<br>";
        }

        String query="INSERT INTO utente VALUES('%S', '%s', '%s', '%S', '%s', '%s')".formatted(Email, Nome, Cognome, Password, Genere, 0);
        PreparedStatement Pstatement = con.prepareStatement(query);
        try{
            int rows = Pstatement.executeUpdate();
            System.out.println("Inserted " + rows + " row(s).");
        }catch (SQLException e){ // se duplicato o dominio non valido
            System.out.println(e.getMessage());
            return "email errata<br>";
        }

        con.close();
        return null;
    }

    //gestire chiusura connessioni

}
