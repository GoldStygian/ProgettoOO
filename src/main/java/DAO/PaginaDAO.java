package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface PaginaDAO {

    public HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) throws SQLException;

    public ArrayList<String> getWikiInfo(int idPagina) throws SQLException;

}
