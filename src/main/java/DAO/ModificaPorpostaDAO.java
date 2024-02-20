package main.java.DAO;

import java.sql.SQLException;

public interface ModificaPorpostaDAO {

    public void AggironamentoProposta(int id_proposta, String Email, String Testo);

    public int NumeroModifiche(String email) throws SQLException;

}
