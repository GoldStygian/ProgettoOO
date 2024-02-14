package main.java.DAO;

import java.sql.SQLException;

public interface RegisterDAO {

    public String RegisterUser(String Nome, String Cognome, String Genere, String Email, String Password) throws SQLException;

}
