package main.java.ImplementazionePostgresDAO;

import main.java.DAO.NotificheDAO;
import main.java.GUI.WikiPage;
import main.java.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotifichePostgresDAO implements NotificheDAO  {

    @Override
    public ArrayList<Notifica> LoadNotifiche(String EmailAutore, HashMap<Integer, Pagina> Pagine ) throws SQLException {
        ArrayList<Notifica> n = new ArrayList<Notifica>();

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECSELECT id_operazione, datar, pagina_frase, modifica, acettata, visionata FROM notifica WHERE autore_notificato = '%s'".formatted(EmailAutore);
        ResultSet Notifiche = statement.executeQuery(query);


        while(Notifiche.next()){
           int id_pagina = Notifiche.getInt("pagina_frase");
           Pagina p = Pagine.get(id_pagina);
           HashMap<Integer, Frase> Frasi = p.getFrasi();
           if(Notifiche.getBoolean("modifica")){
               InserimentoUtente ins = new InserimentoUtente(Notifiche.getDate("datar"), Notifiche.getBoolean("accettata"), Notifiche.getBoolean("visionata"));

           }

        }

        return n;
    }

    @Override
    public void SetNotification() {

    }

}
