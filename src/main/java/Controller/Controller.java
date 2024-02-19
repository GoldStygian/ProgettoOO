package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.HashMap;

public class Controller {

    Utente utenteLoggato = null;

    //debug
    //Utente utenteLoggato = new Autore("florindozec@gmail.com","PasswordForte", "n", "c", 'M');
    //debug
    HashMap<Integer, Pagina> Pagine = new HashMap<>(); //inseriti quando carico la getwiki selezionata //Integer:IdPagina

    public boolean Login(String email, String password) { //OK

        try {
            ArrayList<String> Contenuto =  new LoginPostgresDAO().Login(email, password);

            if(Contenuto !=null) {

                if(Contenuto.get(0).equals("1")){
                    utenteLoggato = new Autore(Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4),Contenuto.get(5).charAt(0));
                }else{
                    utenteLoggato = new Utente(Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4),Contenuto.get(5).charAt(0));
                }

                utenteLoggato.print(); //debug
                if (utenteLoggato instanceof Utente) {
                    System.out.println("[+] l'utente è un utente semplice");//debug
                }else{
                    System.out.println("[+] l'utente è un autore");//debug
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

    public HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) {

        try{
            PaginaDAO p =  new PaginaDAO();
            HashMap<Integer, ArrayList<String>> Frasi = p.getWikiPage(idPagina);
            ArrayList<String> paginaCercata = p.getWikiInfo(idPagina);
            if (paginaCercata!=null){
                Pagina pagina_cercata = new Pagina(paginaCercata.get(0), paginaCercata.get(1), paginaCercata.get(2), paginaCercata.get(3), paginaCercata.get(4));
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

    public boolean isAutore(){
        return utenteLoggato instanceof Autore;
    }

    public  void LoadNotifiche() throws SQLException {

        if(this.isAutore()){
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
       if(this.isAutore()){
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

    public ArrayList<String[]> LoadConfronto(int id_operazione){
        ConfrontaPostgersDAO c = new ConfrontaPostgersDAO();
        try {
            String Confronto = c.LoadConfronto(id_operazione,utenteLoggato.getEmail());
            int index = Confronto.indexOf('+');
            Confronto = Confronto.substring(index+1);
            String [] s = Confronto.split("\\|");
            ArrayList<String[]> Confronti = new ArrayList<>();
            Confronti.add(s[0].split("-"));
            Confronti.add(s[1].split("-"));
            return Confronti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ProponiInserimento(int idPagina, String posizione, String text, boolean selected, String RiferimentoLink) {

        String messageError = "<html>";
        int posizioneInt=-1;

        if (posizione.isEmpty()){
            messageError += "posizione non valida<br>";
        }

        try{
            posizioneInt = Integer.parseInt(posizione);
        }catch (NumberFormatException e){
            messageError += "La posizione deve esssere un numero<br>";
        }

        if (text.isEmpty()){
            return messageError += "Il testo è vuoto<br>";
        }

        String email = utenteLoggato.getEmail();

        Pagina pagina = Pagine.get(idPagina);
        ArrayList<String> frase = pagina.getFrase(Integer.parseInt(posizione));
        if (frase==null){ //la frase non è nell'hashmap
            messageError += "posizione non valida<br>";
        }else{

            Integer posizioneDB = Integer.parseInt(frase.get(0)); //0 : posizione

            Boolean isAutore;
            Pagina currentPage = Pagine.get(idPagina);
            if ( email.equals(currentPage.getEmailAutore())){
                isAutore=true;
            }else{
                isAutore=false;
            }

            try {
                messageError += new WikiPagePostgresDAO().proponiInserimento(isAutore, idPagina, email, text, posizioneDB, selected, RiferimentoLink);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return messageError+"</html>";
    }

    public void SetVisionata(int id_operazione){
        VisualizzaPostgersDAO v = new VisualizzaPostgersDAO();
        try {
            v.Visionata(id_operazione);
        } catch (SQLException e) {
            System.out.printf("visionata");
        }
    }

    public boolean isUserLogged(){

        if (utenteLoggato==null){
            return false;
        }else{
            return true;
        }

    }

    public int NumerOfNotifiche(){
        NotifichePostgresDAO n = new NotifichePostgresDAO();
        try {
            //System.out.printf("\n%d", n.NumberOfNotiche(utenteLoggato.getEmail()));
            return n.NumberOfNotiche(utenteLoggato.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ModificaProposta(int id_operazione, int accettata){
        RisultatoConfrontoPostgresDAO r = new RisultatoConfrontoPostgresDAO();
        if(accettata == 1){
            r.Accettazione(id_operazione, utenteLoggato.getEmail());
        }else{
            r.Rifiuto(id_operazione, utenteLoggato.getEmail());
        }


    }

    /*
    public void SetVisualizzato(int id_operazione){
        if(utenteLoggato instanceof Autore){
            Autore utenteLoggato1 = (Autore) utenteLoggato;

            for(Notifica n : utenteLoggato1.getNotifiche()){
                if(n.getOperazioni_notificate())

            }
        }


    }*/

    public void logOut(){
        this.utenteLoggato= null;
    }

    public String creaPagina(String titolo, String frase, boolean selected, String TitoloPaginaLink) {

        String messageError = "<html>";
        if (titolo.isEmpty()){
            messageError += "Il titolo è vuota<br>";
        }
        else if (frase.isEmpty()){
            messageError += "la frase è vuota<br>";
        }else {

            String email = utenteLoggato.getEmail();
            try {
                messageError += new PaginaDAO().createPage(email, titolo, frase, selected, TitoloPaginaLink);
            }catch (Exception e){
                e.printStackTrace();
                messageError += "Problema sconosciuto<br>";
            }

        }

        return messageError+="</html>";

    }

    public void Resize(int W, int H, JFrame frame){
        frame.setSize(W+1,H);
        frame.setSize(W,H);
    }

}