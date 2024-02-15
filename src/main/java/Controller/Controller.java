package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.Autore;
import main.java.Model.Frase;
import main.java.Model.Pagina;
import main.java.Model.Utente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    Utente utenteLoggato = null;
    HashMap<Integer, Pagina> Pagine = null;

    public boolean Login(String email, String password) {

        try {
            this.utenteLoggato  =  new LoginPostgresDAO().Login(email, password);
            if(utenteLoggato!=null) {
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

    public ArrayList<ArrayList<String>> searchPages(String ricerca) {

        try {
            ArrayList<ArrayList<String>> DataPages = new RicercaPagineDAO().SearchPage(ricerca);
            return DataPages;
        } catch (SQLException e) {
            return null;
        }

    }

    public HashMap<Integer, Frase> getWikiPage(int idPagina) {//fare per id
        try{
            return new GetWikiDAO().getWikiPage(idPagina);
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
}