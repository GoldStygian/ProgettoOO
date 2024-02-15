package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.*;

import java.sql.SQLException;
import java.util.ArrayList;
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
        NotifichePostgresDAO NotificheDao = new NotifichePostgresDAO();
        ArrayList<Notifica> notifiche = new ArrayList<>();
        ArrayList<ArrayList> Dati = NotificheDao.LoadNotifiche(utenteLoggato.getEmail());

        for (int i = 0 ; i<Dati.get(0).size(); i++){



        }


    }


}