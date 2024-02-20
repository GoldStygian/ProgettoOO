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
    public int NumeroModifiche(String email) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();
        String query="SELECT count(*) as sum from operazione_utente where utente like '%s' group by utente".formatted(email);
        ResultSet num = statement.executeQuery(query);
        con.close();
        //num.next();
        //System.out.print("\n|"+num.getInt("sum")+"\n|");
        statement.close();
        num.close();
        return num.getInt("sum");



    }
}
