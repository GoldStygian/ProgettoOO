package main.java.ImplementazionePostgresDAO;

import main.java.DAO.ConfrontaDAO;
import main.java.Database.ConnessionePostges;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfrontaPostgersDAO implements ConfrontaDAO {

    public String LoadConfronto(int id_operazione, String email_autore) throws SQLException {

        Connection con = new ConnessionePostges().openConnection();
        Statement statement = con.createStatement();
        System.out.print(id_operazione + email_autore);

        String query="SELECT visualizzapropostaandconfronta(%d,'%s')".formatted(id_operazione, email_autore);
        ResultSet resultSet = statement.executeQuery(query);

        con.close();

        resultSet.next();
        String Confronto = resultSet.getString("visualizzapropostaandconfronta");
        System.out.println(Confronto);

        resultSet.close();
        statement.close();
        return Confronto;
    }

}
