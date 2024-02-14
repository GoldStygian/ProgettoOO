package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RicercaPagineDAO {

    public ArrayList<ArrayList<String>> SearchPage(String ricerca) throws SQLException;


}
