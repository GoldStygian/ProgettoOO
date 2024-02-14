package main.java.DAO;

import java.sql.SQLException;
import java.util.HashMap;

public interface GetWikiDAO {

    public HashMap<Integer, String> getWikiPage(String titolo) throws SQLException;

}
