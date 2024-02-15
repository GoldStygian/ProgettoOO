package main.java.ImplementazionePostgresDAO;

import main.java.DAO.NotificheDAO;
import main.java.GUI.WikiPage;
import main.java.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NotifichePostgresDAO implements NotificheDAO  {

    @Override
    public ArrayList<ArrayList> LoadNotifiche(String EmailAutore) throws SQLException {


        ArrayList<ArrayList> Dati = new ArrayList<>();

        Dati.add(new ArrayList<Date>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Boolean>());

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECSELECT id_operazione, datar, pagina_frase, modifica, acettata, visionata, FROM notifica WHERE autore_notificato = '%s'".formatted(EmailAutore);
        ResultSet Notifiche = statement.executeQuery(query);

        con.close();

        while(Notifiche.next()){
            int row = 0;
            for (ArrayList l : Dati){
                if(row == 0){
                    l.add(Notifiche.getDate("datar"));
                }else if(row == 1){
                    l.add(Notifiche.getBoolean("visionata"));
                }else if(row == 2){
                    l.add(Notifiche.getBoolean("accettata"));
                }else if (row == 3){
                    l.add(Notifiche.getBoolean("modifica"));
                }
                row++;

            }
        }

        Notifiche.close();
        statement.close();
        /*
        if(Notifiche.getBoolean("modifica")){
            Notifica NewNotifica = new Notifica(new InserimentoUtente(Notifiche.getDate("datar"), Notifiche.getBoolean("accettata"), Notifiche.getBoolean("visionata")));
            n.add(NewNotifica);
        }else{
            Notifica NewNotifica = new Notifica(new ModificaUtente(Notifiche.getDate("datar"), Notifiche.getBoolean("accettata"), Notifiche.getBoolean("visionata")));
            n.add(NewNotifica);

        }
        */
        return Dati;
    }

    @Override
    public void SetNotification() {

    }

}
