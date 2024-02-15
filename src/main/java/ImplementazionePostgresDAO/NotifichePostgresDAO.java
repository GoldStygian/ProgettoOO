package main.java.ImplementazionePostgresDAO;

import main.java.DAO.NotificheDAO;
import main.java.GUI.WikiPage;
import main.java.Model.Notifica;
import main.java.Model.OperazioneAutore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NotifichePostgresDAO implements NotificheDAO  {

    @Override
    public ArrayList<Notifica> LoadNotifiche(String EmailAutore) throws SQLException {
        ArrayList<Notifica> n = new ArrayList<Notifica>();

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECSELECT id_operazione, datar, pagina_frase, modifica FROM notifica WHERE autore_notificato = '%s'".formatted(EmailAutore);
        ResultSet Notifiche = statement.executeQuery(query);

        GetWikiDAO Wiki;

        while(Notifiche.next()){
           // Wiki.getWikiPage()


        }

        return n;
    }

    @Override
    public void SetNotification() {

    }

}
