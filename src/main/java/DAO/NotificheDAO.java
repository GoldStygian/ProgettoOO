package main.java.DAO;

import main.java.Model.Notifica;
import main.java.Model.Pagina;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface NotificheDAO {

    public ArrayList<ArrayList> LoadNotifiche(String EmailAutore) throws SQLException;


    public  int  NumberOfNotiche(String EmailAutore) throws SQLException;
}
