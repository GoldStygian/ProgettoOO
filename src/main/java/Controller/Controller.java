package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.*;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;

public class Controller {

    Utente utenteLoggato = null;
    HashMap<Integer, Pagina> Pagine = new HashMap<>();

    public boolean Login(String email, String password) { //OK

        try {
            ArrayList<String> Contenuto =  new LoginPostgresDAO().Login(email, password);

            if(Contenuto !=null) {

                if(Contenuto.get(0).equals("1")){
                    Contenuto.removeFirst();
                    utenteLoggato = new Autore(Contenuto.get(0),Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4).charAt(0));

                }else{
                    utenteLoggato = new Utente(Contenuto.get(0),Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4).charAt(0));
                }

                utenteLoggato.print(); //debug
                if (utenteLoggato instanceof Utente) {
                    System.out.println("[+] l'utente è un utente semplice");
                }else{
                    System.out.println("[+] l'utente è un autore");
                }
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public ArrayList<ArrayList<String>> searchPages(String ricerca) {//OK

        try {
            return new RicercaPagineDAO().SearchPage(ricerca);
        } catch (SQLException e) {
            return null;
        }

    }

    public HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) {//ok1

        try{
            PaginaDAO p =  new PaginaDAO();
            HashMap<Integer, ArrayList<String>> Frasi = p.getWikiPage(idPagina);
            ArrayList<String> paginaCercata = p.getWikiInfo(idPagina);
            if (paginaCercata!=null){
                Pagina pagina_cercata = new Pagina(paginaCercata.get(0), paginaCercata.get(1), paginaCercata.get(2), paginaCercata.get(3));
                pagina_cercata.AddFrasi(Frasi);
                Pagine.put(idPagina, pagina_cercata);
            }
            return Frasi;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String register(String Nome, String Cognome, Object Genere, String Email, String Password) {

        String messageError = "<html>";
        try{
            messageError += new RegisterPostgerDAO().RegisterUser(Nome, Cognome, Genere.toString(), Email, Password);
        }catch (Exception e){
            System.out.println("[-] "+e.getMessage());
            messageError += "problema sconosciuto<br>";
        }

        return messageError+"</html>";
    }

    public boolean GetAutoreLog(){
        return utenteLoggato instanceof Autore;
    }

    public  void LoadNotifiche() throws SQLException {

        if(this.GetAutoreLog()){
            NotifichePostgresDAO NotificheDao = new NotifichePostgresDAO();
            ArrayList<ArrayList> Dati = NotificheDao.LoadNotifiche(utenteLoggato.getEmail());
            Autore utenteLoggato1 = (Autore) utenteLoggato;
            utenteLoggato1.ResetNotifiche();

            //System.out.print((Dati.get(0).get(1)));
            for (int i = 0 ; i < Dati.get(0).size(); i++){
                if(!((Boolean) Dati.get(5).get(i))){
                    //System.out.printf(String.valueOf((Dati.get(0).get(i)).getClass()) + String.valueOf((Dati.get(1).get(i)).getClass()) + String.valueOf((Dati.get(2).get(i)).getClass())+ String.valueOf((Dati.get(3).get(i)).getClass())+ String.valueOf((Dati.get(4).get(i)).getClass())+ String.valueOf((Dati.get(5).get(i)).getClass())+ String.valueOf((Dati.get(6).get(i)).getClass())+ String.valueOf((Dati.get(7).get(i)).getClass())+ String.valueOf((Dati.get(8).get(i)).getClass())+ String.valueOf((Dati.get(9).get(i)).getClass()));
                    utenteLoggato1.addNotifica(new Notifica(new InserimentoUtente((int) Dati.get(0).get(i),(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(int) Dati.get(8).get(i),(String) Dati.get(9).get(i))));
                    //new Notifica(new InserimentoUtente((Date) Dati.get(0).get(i), (Boolean) Dati.get(1).get(i),(Boolean) Dati.get(2).get(i)));
                    //System.out.println("io");
                }else{
                    utenteLoggato1.addNotifica(new Notifica(new ModificaUtente((int) Dati.get(0).get(i) ,(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(String) Dati.get(9).get(i))));
                }

            }

        }
    }

    public ArrayList<ArrayList> GetNotifiche(){

        ArrayList<ArrayList> s = null;
       if(this.GetAutoreLog()){
           s = new ArrayList<>();
           s.add(new ArrayList<Integer>());
           s.add(new ArrayList<Timestamp>());
           s.add(new ArrayList<String>());
           s.add(new ArrayList<Boolean>());
           s.add(new ArrayList<Boolean>());
           s.add(new ArrayList<Boolean>());
           s.add(new ArrayList<Boolean>());
           s.add(new ArrayList<Integer>());
           s.add(new ArrayList<Integer>());
           s.add(new ArrayList<String>());
           Autore utenteLoggato1 = (Autore) utenteLoggato;
           for(Notifica n: utenteLoggato1.getNotifiche()){
               s.get(0).add(n.getOperazioni_notificate().getIdOperazione());
               s.get(1).add(n.getOperazioni_notificate().getDataR());
               s.get(2).add(n.getOperazioni_notificate().getTesto());
               s.get(3).add(n.getOperazioni_notificate().getAccettata());
               s.get(4).add(n.getOperazioni_notificate().getVisionata());
               s.get(5).add(n.getOperazioni_notificate().getModifica());
               s.get(6).add(n.getOperazioni_notificate().getLink());
               s.get(7).add(n.getOperazioni_notificate().getLink_pagina());
               if(n.getOperazioni_notificate() instanceof InserimentoUtente){
                   s.get(8).add( ((InserimentoUtente)(n.getOperazioni_notificate())).getPosizione());
               }

               s.get(9).add(n.getOperazioni_notificate().getUtente());

           }


       }
        return s;

    }

}