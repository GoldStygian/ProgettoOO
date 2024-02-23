package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class Controller {

    //Utente utenteLoggato = null;

    //debug
        private Utente utenteLoggato = new Autore("florindozec@gmail.com","PasswordForte", "n", "c", 'M');
    //debug
    private HashMap<Integer, Pagina> Pagine = new HashMap<>(); //inseriti quando carico la getwiki selezionata //Integer:IdPagina
    private ArrayList<OperazioneUtente> Operazioni_utente = new ArrayList<>();

    /**
     * Funzione per effettuare il login
     * Chiama il metodo Login di LoginDAO
     * se Login di Login DAO ritorna 1 allora significa che l'utnete è un autore
     * se Login di Login DAO ritorna 0 allora significa che l'utente è un utente semplice
     * se Login di Login DAO ritorna null allora email e password non combaciano.
     * La funzione ritonra true se il login è effettuato con successo altrimenti false
     * in caso di problemi o di credenziali errate. @author
     */

    public boolean Login(String email, String password) {

        try {
            ArrayList<String> Contenuto =  new LoginPostgresDAO().Login(email, password);

            if(Contenuto !=null) {

                if(Contenuto.get(0).equals("1")){
                    utenteLoggato = new Autore(Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4),Contenuto.get(5).charAt(0));
                }else{
                    utenteLoggato = new Utente(Contenuto.get(1),Contenuto.get(2),Contenuto.get(3),Contenuto.get(4),Contenuto.get(5).charAt(0));
                }

                //utenteLoggato.print(); //debug
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     *
     */
    public ArrayList<ArrayList<String>> searchPages(String ricerca) {//OK

        try {
            return new PaginaPostgresDAO().SearchPage(ricerca);
        } catch (SQLException e) {
            return null;
        }

    }

    public HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) {
        // idPag
        // pos reale
        // frase
        // link
        // id link

        if (Pagine.get(idPagina) != null) { //gia sta una pagina nell'hashmap

            Pagina StoredPage = Pagine.get(idPagina);
            HashMap<Integer, ArrayList<String>> frasi = new HashMap<>();
            if (StoredPage.getFrasi()!=null){
            for (Map.Entry<Integer, Frase> entry : StoredPage.getFrasi().entrySet()){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(String.valueOf(idPagina));
                temp.add(String.valueOf(entry.getValue().getPosizione()));
                temp.add(entry.getValue().getTesto());

                if (entry.getValue() instanceof Link){
                    temp.add(String.valueOf(1));
                    temp.add(String.valueOf(((Link) entry.getValue()).getPaginaId()));
                }else{
                    temp.add(String.valueOf(0));
                    temp.add("null");
                }
                frasi.put(entry.getKey(), temp);
            }

            return frasi;
            }else {
                return null;
            }



        } else { //devo caricare dal DB
            try {
                PaginaPostgresDAO p = new PaginaPostgresDAO();
                HashMap<Integer, ArrayList<String>> Frasi = p.getWikiPage(idPagina);
                ArrayList<String> paginaCercata = p.getWikiInfo(idPagina);
                if (paginaCercata != null) {
                    Pagina pagina_cercata = new Pagina(paginaCercata.get(0), paginaCercata.get(1), paginaCercata.get(2), paginaCercata.get(3), paginaCercata.get(4), Integer.parseInt(paginaCercata.get(5)) );

                    for (Map.Entry<Integer, ArrayList<String>> entry : Frasi.entrySet()) {
                        //0 idPagina
                        //1 1
                        //2 testo
                        //3 link
                        //4 idLink
                        Frase frase;
                        if (entry.getValue().get(3).equals("1")){ //se è un link
                            ArrayList<String> PaginaLinkRow = p.getWikiInfo(Integer.parseInt(entry.getValue().get(4)));
                            Pagina PaginaLink = new Pagina(PaginaLinkRow.get(0), PaginaLinkRow.get(1), PaginaLinkRow.get(2), PaginaLinkRow.get(3), PaginaLinkRow.get(4), Integer.parseInt(PaginaLinkRow.get(5)));
                            frase = new Link(entry.getValue().get(2), Integer.parseInt(entry.getValue().get(1)), PaginaLink);//testo //posizione
                        }else{
                            frase = new Frase(entry.getValue().get(2), Integer.parseInt(entry.getValue().get(1)));
                        }

                        pagina_cercata.AddFrase(frase, entry.getKey());

                    }

                    Pagine.put(idPagina, pagina_cercata);
                }
                return Frasi;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
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

    /**
     * Controlla se l'utente loggato è un autore
     *
     * @return True se è autore, False se è un Utente
     */
    public boolean isAutore(){
        return utenteLoggato instanceof Autore;
    }

    /**
     * Controlla se l'utente loggato è un autore tramite isAutore().
     * Crea un oggetto di NotifichePostgresDAO.
     * richiama la funzione LoadNotifiche(Email Autore) che restituisce una Matrice con tutti i dati restituiti dal DataBase
     * Per ogni colonna della matrice creiamo un oggetto ModificaUtente se il parametro a riga 5 colonna i(quindi i-esima Operazione) è true
     * altrimenti un inserimento
     */
    public  void LoadNotifiche() throws SQLException {

        if(this.isAutore()){
            NotifichePostgresDAO NotificheDao = new NotifichePostgresDAO();
            ArrayList<ArrayList> Dati = NotificheDao.LoadNotifiche(utenteLoggato.getEmail());
            Autore utenteLoggato1 = (Autore) utenteLoggato;
            utenteLoggato1.ResetNotifiche();

            //System.out.print((Dati.get(0).get(1)));
            for (int i = 0 ; i < Dati.get(0).size(); i++){
                if(!((Boolean) Dati.get(5).get(i))){
                    InserimentoUtente ToAdd = new InserimentoUtente((int) Dati.get(0).get(i),(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(int) Dati.get(8).get(i),(String) Dati.get(9).get(i));
                    //System.out.printf(String.valueOf((Dati.get(0).get(i)).getClass()) + String.valueOf((Dati.get(1).get(i)).getClass()) + String.valueOf((Dati.get(2).get(i)).getClass())+ String.valueOf((Dati.get(3).get(i)).getClass())+ String.valueOf((Dati.get(4).get(i)).getClass())+ String.valueOf((Dati.get(5).get(i)).getClass())+ String.valueOf((Dati.get(6).get(i)).getClass())+ String.valueOf((Dati.get(7).get(i)).getClass())+ String.valueOf((Dati.get(8).get(i)).getClass())+ String.valueOf((Dati.get(9).get(i)).getClass()));
                    utenteLoggato1.addNotifica(new Notifica(ToAdd));
                    Operazioni_utente.add(ToAdd);
                    //new Notifica(new InserimentoUtente((Date) Dati.get(0).get(i), (Boolean) Dati.get(1).get(i),(Boolean) Dati.get(2).get(i)));
                    //System.out.println("io");
                }else{
                    ModificaUtente ToAdd = new ModificaUtente((int) Dati.get(0).get(i) ,(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(String) Dati.get(9).get(i));
                    utenteLoggato1.addNotifica(new Notifica(ToAdd));
                    Operazioni_utente.add(ToAdd);
                }

            }

        }
    }

    /**
     * carica una matrice con tutti i dati utili di una notifica, come:
     * Id_operazionme, DataR(data Richiesta),Testo, accettata, Visionata,Modifica, Link ,Link_pagina,posizione e utente
     * dopo che ha carivato la matrice la restituisce
     *
     *
     * @return Una Matrice con i dati di ogni Notifica nel model. dove La riga Corrisponde a un tipo di dato del model
     * e un a colonna a un oggetto. Es: matrice 5x5 ho 5 attributi e 5 oggetti. Es: matrice 5x7 ho 5 attributi e sette oggetti
     * {riga}x{colonna}
     */
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

    /**
     *  Crea un Oggetto ConfrontaPostgersDAO() e richiamo una sua funzione di nome Confronti LoadConfronto(id_operazione , email Autore)
     *  LoadConfronto ritornerà un stringa formattata nel seguente modo:
     *
     *
     * @param id_operazione
     * @return
     */
    public ArrayList<String[]> LoadConfronto(int id_operazione){
        ConfrontaPostgersDAO c = new ConfrontaPostgersDAO();
        try {
            ArrayList<String[]> Confronti = new ArrayList<>();
            String Confronto = c.LoadConfronto(id_operazione,utenteLoggato.getEmail());
            int index = Confronto.indexOf('+');
            Confronto = Confronto.substring(index+1);
            if(Confronto.contains("|")){
                String [] s = Confronto.split("\\|");
                Confronti.add(s[0].split("-"));
                Confronti.add(s[1].split("-"));
            }else{
                Confronti.add(Confronto.split("-"));
            }

            return Confronti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadModifiche(){
        ModifichePostgresDAO ModificheDao = new ModifichePostgresDAO();
        ArrayList<ArrayList> Dati;
        try {
            Dati = ModificheDao.LoadModifiche(utenteLoggato.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Operazioni_utente.clear();

        //System.out.printf(String.valueOf(Dati));

        for (int i = 0 ; i < Dati.get(0).size(); i++){
            this.AggiornamentoModifiche((int) Dati.get(0).get(i),(String) Dati.get(11).get(i),(String) Dati.get(12).get(i),(Timestamp) Dati.get(10).get(i),(String) Dati.get(13).get(i));
            if(!((Boolean) Dati.get(5).get(i))){
                InserimentoUtente ToAdd = new InserimentoUtente((int) Dati.get(0).get(i),(Timestamp) Dati.get(10).get(i),(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(int) Dati.get(8).get(i),(String) Dati.get(9).get(i),(String) Dati.get(11).get(i),(String) Dati.get(12).get(i),(String) Dati.get(13).get(i));
                //System.out.printf(String.valueOf((Dati.get(0).get(i)).getClass()) + String.valueOf((Dati.get(1).get(i)).getClass()) + String.valueOf((Dati.get(2).get(i)).getClass())+ String.valueOf((Dati.get(3).get(i)).getClass())+ String.valueOf((Dati.get(4).get(i)).getClass())+ String.valueOf((Dati.get(5).get(i)).getClass())+ String.valueOf((Dati.get(6).get(i)).getClass())+ String.valueOf((Dati.get(7).get(i)).getClass())+ String.valueOf((Dati.get(8).get(i)).getClass())+ String.valueOf((Dati.get(9).get(i)).getClass()));
                Operazioni_utente.add(ToAdd);
                //new Notifica(new InserimentoUtente((Date) Dati.get(0).get(i), (Boolean) Dati.get(1).get(i),(Boolean) Dati.get(2).get(i)));
                //System.out.println("io");
            }else{
                ModificaUtente ToAdd = new ModificaUtente((int) Dati.get(0).get(i),(Timestamp) Dati.get(10).get(i) ,(Timestamp) Dati.get(1).get(i),(String) Dati.get(2).get(i),(Boolean)Dati.get(3).get(i),(Boolean)Dati.get(4).get(i),(Boolean)Dati.get(5).get(i),(Boolean)Dati.get(6).get(i),(int) Dati.get(7).get(i),(String) Dati.get(9).get(i),(String) Dati.get(11).get(i),(String) Dati.get(12).get(i),(String) Dati.get(13).get(i));
                Operazioni_utente.add(ToAdd);
            }

        }

    }

    public ArrayList<ArrayList> GetModifiche(){

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
            s.add(new ArrayList<Timestamp>());
            s.add(new ArrayList<String>());
            s.add(new ArrayList<String>());
            s.add(new ArrayList<String>());

            Autore utenteLoggato1 = (Autore) utenteLoggato;
            for(OperazioneUtente n: Operazioni_utente){
                s.get(0).add(n.getIdOperazione());
                s.get(1).add(n.getDataR());
                s.get(2).add(n.getTesto());
                s.get(3).add(n.getAccettata());
                s.get(4).add(n.getVisionata());
                s.get(5).add(n.getModifica());
                s.get(6).add(n.getLink());
                s.get(7).add(n.getLink_pagina());
                if(n instanceof InserimentoUtente){
                    s.get(8).add( ((InserimentoUtente)(n)).getPosizione());
                }else{
                    s.get(8).add(0);
                }


                s.get(9).add(n.getUtente());
                s.get(10).add(n.getDataA());
                s.get(11).add(n.getUtenteNotificato());
                s.get(12).add(n.getTitoloPaginaLink());
                s.get(13).add(n.getTitolo());

            }

        }
        return s;
    }

    public void AggiornamentoModifiche(int id_operazione, String Autore, String Titolo, Timestamp Data, String TitoloPagina){
        for(OperazioneUtente u: Operazioni_utente){
            if(u.getIdOperazione() == id_operazione){
                ((OperazioneUtente) u).SetAutore(Autore);
                ((OperazioneUtente) u).SetTitoloLink(Titolo);
                ((OperazioneUtente) u).SetDataA(Data);
                ((OperazioneUtente) u).SetTitolo(Titolo);
            }

        }

    }

    public void SetVisionataNotificheModel(int id_operazione){
        for(OperazioneUtente u: Operazioni_utente){
            if(u.getIdOperazione() == id_operazione){
                ((OperazioneUtente) u).SetVisionata(true);
                return;
            }
        }
    }

    public String ProponiInserimento(int idPagina, String posizione, String text, boolean selected, String RiferimentoLink) {

        String messageError = "<html>";
        int posizioneInt=-1;

        if (posizione.isEmpty()){
            messageError += "posizione non valida<br>";
        }

        if (text.isEmpty()){
            return messageError += "Il testo è vuoto<br>";
        }

        try{
            posizioneInt = Integer.parseInt(posizione);
        }catch (NumberFormatException e){
            messageError += "La posizione deve esssere un numero<br>";
            return messageError;
        }

        Pagina pagina = Pagine.get(idPagina);
        Frase frase = pagina.getFrase(Integer.parseInt(posizione));

        Integer posizioneDB = posizioneInt;
        if (frase==null){ //la frase non è nell'hashmap
            //messageError += "posizione non valida<br>";
            int lastIdxFrase=pagina.getLastIdxFrase(); //puo essere l'ultima
            if (lastIdxFrase<posizioneInt){
                //System.out.println("stai inserendo in coda");
                //posizioneDB= Integer.valueOf(pagina.getFrase(lastIdxFrase).get(0))+1;
                posizioneDB= pagina.getFrase(lastIdxFrase).getPosizione()+1;
            }
        }else{
            //posizioneDB = Integer.parseInt(frase.get(0));  //0 : posizione
            posizioneDB = frase.getPosizione();
        }


            Boolean isAutore;
            Pagina currentPage = Pagine.get(idPagina);
            String email = utenteLoggato.getEmail();
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


        return messageError+"</html>";
    }

    public String ProponiModifica(int idPagina, int posizione, String text, boolean link, String titoloLink) {
        //id_pagina //strong
        //email //strong
        //testo //to check
        //link //to check
        //titolo link //to check
        //posizione //strong

        //System.out.println("la posizione che stai modificando è la: "+posizione);

        String Message = "<html>";
        if (text.isEmpty()){
            Message+="Il testo è vuoto<br>";
        }else {

            Boolean isAutore;
            String email = utenteLoggato.getEmail();
            Pagina currentPage = Pagine.get(idPagina);
            if (email.equals(currentPage.getEmailAutore())){
                isAutore=true;
            }else{
                isAutore=false;
            }

            Pagina pagina = Pagine.get(idPagina);
            //ArrayList<String> frase = pagina.getFrase(posizione);
            Frase frase = pagina.getFrase(posizione);
            //posizione = Integer.parseInt(frase.get(0));
            posizione = frase.getPosizione();


            try{
                Message+= new WikiPagePostgresDAO().proponiModifica(isAutore, idPagina, email, text, posizione, link, titoloLink);
            }catch (Exception e){
                e.printStackTrace();
                Message+="problema sconosciuto<br>";
            }
        }

        return Message+"</html>";
    }

    public void SetVisionata(int id_operazione){
        VisualizzaPostgersDAO v = new VisualizzaPostgersDAO();
        try {
            v.Visionata(id_operazione);
        } catch (SQLException e) {
            //System.out.printf("visionata");
        }
    }

    public boolean isUserLogged(){

        if (utenteLoggato==null){
            return false;
        }else{
            return true;
        }

    }

    public void ModificaPropsostaEffetuata(int id_proposta,String Testo){
        ModificaPorpostaPostgresDAO m = new ModificaPorpostaPostgresDAO();
        m.AggironamentoProposta(id_proposta,utenteLoggato.getEmail(),Testo);
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

    public int NumerOfModifiche(){
        ModificaPorpostaPostgresDAO m = new ModificaPorpostaPostgresDAO();
        try {
            return m.NumeroModifiche(utenteLoggato.getEmail());
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

    public ArrayList<ArrayList<String>> getMyPage(){

        String email = utenteLoggato.getEmail();
        ArrayList<ArrayList<String>> pages;
        try{
            pages = new PaginaPostgresDAO().getMyPage(email);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        if (pages.isEmpty()){
            return null;
        }else{
            return pages;
        }
    }

    public ArrayList<ArrayList<String>> getStoricitaPage(int idPage, String Data){

        ArrayList<ArrayList<String>> frasi;
        try {
            frasi = new PaginaPostgresDAO().getStroicitaSpecifica(idPage, Data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


        return frasi;
    }

    public ArrayList<String> getDateAvailable(int idPagina){

        try {
            return new PaginaPostgresDAO().getDateAvailable(idPagina);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void logOut(){

        this.utenteLoggato= null;
        this.Operazioni_utente = null;
        Operazioni_utente = new ArrayList<>();
    }

    public String creaPagina(String titolo, String frase, boolean selected, String TitoloPaginaLink) {

        String messageError = "<html>";
        if (titolo.isEmpty()){
            messageError += "Il titolo è vuoto<br>";
        }
        else if (frase.isEmpty()){
            messageError += "La frase è vuota<br>";
        }else {

            String email = utenteLoggato.getEmail();
            try {
                messageError += new PaginaPostgresDAO().createPage(email, titolo, frase, selected, TitoloPaginaLink);
            }catch (Exception e){
                //e.printStackTrace();
                messageError += "Problema sconosciuto<br>";
            }

        }

        return messageError+="</html>";

    }

    public void Resize(int W, int H, JFrame frame){
        frame.setSize(W+1,H);
        frame.setSize(W,H);
    }

    public void removePage(int idPagina) {
        System.out.println(idPagina);
        Pagine.remove(idPagina);
    }
}