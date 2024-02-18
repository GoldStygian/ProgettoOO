package main.java.ImplementazionePostgresDAO;

import main.java.DAO.ConfrontaDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConfrontaPostgersDAO implements ConfrontaDAO {

    public String LoadConfronto(int id_operazione, String email_autore) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();


        String query="SELECT visualizzapropostaandconfronta(%d,'%s')".formatted(id_operazione, email_autore);
        ResultSet resultSet = statement.executeQuery(query);

        // Chiusura delle risorse
        con.close();

        resultSet.next();
        String Confronto = resultSet.getString("visualizzapropostaandconfronta");
        System.out.print(Confronto + "\n");

        resultSet.close();
        statement.close();
        return Confronto;
    }

}
