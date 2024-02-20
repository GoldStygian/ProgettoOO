package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ModificheDAO {

    public ArrayList<ArrayList> LoadModifiche(String EmailUtente) throws SQLException;
}
