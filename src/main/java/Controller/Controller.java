package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;
import main.java.Model.Autore;
import main.java.Model.Utente;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    Utente utenteLoggato = null;

    public boolean Login(String email, String password) {

        try {
            this.utenteLoggato  =  new LoginPostgresDAO().Login(email, password);
            if(utenteLoggato!=null) {
                utenteLoggato.print(); //debug
                if (utenteLoggato instanceof Utente) {
                    System.out.println("[+] l'utente è un utente seplice");
                }

                if (utenteLoggato instanceof Autore) {
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
    /*
    public boolean Login(String email, String password) {

        try {
            boolean login =  new LoginPostgresDAO().Login(email, password);
            if(login) {this.login=email; this.password=password;} // gestire meglio
            return  login;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }*/

    public ArrayList<ArrayList<String>> searchPages(String ricerca) {

        try {
            ArrayList<ArrayList<String>> DataPages = new RicercaPagineDAO().SearchPage(ricerca);
            return DataPages;
        } catch (SQLException e) {
            return null;
        }

    }

    public void getWikiPage(String titolo) {//da finire
        try{
            new GetWikiDAO().getWikiPage(titolo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String register(String Nome, String Cognome, Object Genere, String Email, String Password) {
        /*
        System.out.println("Nome:" + Nome+"'");
        System.out.println("Cognome: " + Cognome);
        System.out.println("Genere: " + Genere.toString());
        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);*/

        String messageError = "<html>";
        try{
            messageError += new RegisterPostgerDAO().RegisterUser(Nome, Cognome, Genere.toString(), Email, Password);
        }catch (Exception e){
            System.out.println("[-] "+e.getMessage());
            messageError += "problema sconosciuto<br>";
        }

        return messageError+"</html>";
    }
}