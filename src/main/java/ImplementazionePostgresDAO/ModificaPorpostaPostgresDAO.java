package main.java.ImplementazionePostgresDAO;

import main.java.DAO.ModificaPorpostaDAO;
import main.java.DAO.ModificheDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificaPorpostaPostgresDAO implements ModificaPorpostaDAO {

    @Override
    public void AggironamentoProposta(int id_proposta, String Email, String Testo) {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
            String query="call modificarichestaproposta(%d,'%s'::VARCHAR(41),'%s'::text)".formatted(id_proposta,Email,Testo);
            statement.executeQuery(query);
            con.close();
            statement.close();
        } catch (SQLException e) {
            System.out.printf("[] Messaggio:%s CODE: %d\n",e.getMessage(),e.getErrorCode());
        }


    }

    @Override
    public int NumeroModifiche(String email) {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = null;
        ResultSet num = null;
        try {
            statement = con.createStatement();
            String query="SELECT count(*) as sum from operazione_modifiche where utente like '%s'".formatted(email);
            num = statement.executeQuery(query);
            statement.close();
            con.close();
        } catch (SQLException e) {
            System.out.printf("[] Messaggio:%s CODE: %d\n",e.getMessage(),e.getErrorCode());
        }

        try {
            num.next();
            return num.getInt("sum");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
