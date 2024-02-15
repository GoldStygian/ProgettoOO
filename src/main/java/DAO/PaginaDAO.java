package main.java.DAO;

import main.java.Model.Frase;
import main.java.Model.Pagina;

import java.sql.SQLException;
import java.util.HashMap;

public interface PaginaDAO {

    public HashMap<Integer, Frase> getWikiPage(int idPagina) throws SQLException;

    public Pagina getWikiInfo(int idPagina) throws SQLException;

}
