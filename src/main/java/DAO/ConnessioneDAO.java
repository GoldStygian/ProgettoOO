package main.java.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnessioneDAO {


    public Connection openConnection();

}