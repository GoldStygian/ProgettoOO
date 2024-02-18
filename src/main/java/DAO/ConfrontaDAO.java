package main.java.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ConfrontaDAO {

    public String LoadConfronto(int id_operazione, String email_autore) throws SQLException;
}
