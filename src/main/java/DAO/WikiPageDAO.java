package main.java.DAO;

import java.sql.SQLException;

public interface WikiPageDAO {

    String proponiInserimento(int idPagina, String email, String text, int posizione, boolean selected, String riferimentoLink) throws SQLException;
}