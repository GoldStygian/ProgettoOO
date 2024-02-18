package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PaginaDAO {

    HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) throws SQLException;

    ArrayList<String> getWikiInfo(int idPagina) throws SQLException;

    void createPage(String titolo, String frase);
}
