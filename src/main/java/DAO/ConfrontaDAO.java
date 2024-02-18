package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ConfrontaDAO {

    public ArrayList<ArrayList> LoadConfronto(int id_operazione, String email_autore) throws SQLException;
}
