package main.java.DAO;

import java.sql.SQLException;

public interface LoginDAO {

    public boolean Login(String email, String password) throws SQLException;

}
