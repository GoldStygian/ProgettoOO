package main.java.DAO;

import main.java.Model.Frase;

import java.sql.SQLException;
import java.util.HashMap;

public interface GetWikiDAO {

    public HashMap<Integer, Frase> getWikiPage(String titolo) throws SQLException;

}
