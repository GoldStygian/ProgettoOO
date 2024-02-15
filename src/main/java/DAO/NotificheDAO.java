package main.java.DAO;

import main.java.Model.Notifica;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NotificheDAO {

    public ArrayList<Notifica> LoadNotifiche(String EmailAutore) throws SQLException;

    public void SetNotification();
}
