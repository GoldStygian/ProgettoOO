package main.java.DAO;

import java.sql.SQLException;

public interface RisultatoConfrontoDAO {

    public void Accettazione(int id_operazione, String Email);

    public void Rifiuto(int id_operazione, String Email);

}
