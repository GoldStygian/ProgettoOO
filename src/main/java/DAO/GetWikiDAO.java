package main.java.DAO;

import java.sql.SQLException;

public interface GetWikiDAO {

    public void getWikiPage(String titolo) throws SQLException;

}
