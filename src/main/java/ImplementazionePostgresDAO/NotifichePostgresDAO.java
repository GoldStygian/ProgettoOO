package main.java.ImplementazionePostgresDAO;

import main.java.DAO.NotificheDAO;


import java.sql.*;
import java.util.ArrayList;
import java.sql.Timestamp;



public class NotifichePostgresDAO implements NotificheDAO  {

    @Override
    public ArrayList<ArrayList> LoadNotifiche(String EmailAutore) throws SQLException {


        ArrayList<ArrayList> Dati = new ArrayList<>();

        Dati.add(new ArrayList<Integer>());
        Dati.add(new ArrayList<Timestamp>());
        Dati.add(new ArrayList<String>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Boolean>());
        Dati.add(new ArrayList<Integer>());
        Dati.add(new ArrayList<Integer>());
        Dati.add(new ArrayList<String>());

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM notifica WHERE autore_notificato = '%s' ORDER BY visionata ASC".formatted(EmailAutore);
        ResultSet Notifiche = statement.executeQuery(query);

        con.close();

        while(Notifiche.next()){
            int row = 0;
            for (ArrayList l : Dati){
                if(row == 0){
                    l.add(Notifiche.getInt("id_operazione"));
                }else if(row ==1){
                    l.add(Notifiche.getTimestamp("datar"));
                }else if(row ==2){
                    l.add(Notifiche.getString("testo"));
                }else if(row ==3){
                    l.add(Notifiche.getBoolean("accettata"));
                }else if(row ==4){
                    l.add(Notifiche.getBoolean("visionata"));
                }else if(row ==5){
                    l.add(Notifiche.getBoolean("modifica"));
                }else if(row ==6){
                    l.add(Notifiche.getBoolean("link"));
                }else if(row ==7){
                    l.add(Notifiche.getInt("link_pagina"));
                }else if(row ==8){
                    l.add(Notifiche.getInt("posizioneins"));
                }else if(row ==9){
                    l.add(Notifiche.getString("utente"));

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



    public int NumberOfNotiche(String EmailAutore) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT count(*) as number FROM notifica WHERE autore_notificato = '%s'".formatted(EmailAutore);
        ResultSet Notifiche = statement.executeQuery(query);

        Notifiche.next();
        int n = Notifiche.getInt("number");
        //System.out.print("\n||"+n+"||\n");
        con.close();
        Notifiche.close();
        statement.close();

        return n;
    }
}
