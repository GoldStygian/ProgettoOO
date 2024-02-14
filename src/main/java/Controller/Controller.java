package main.java.Controller;

import main.java.ImplementazionePostgresDAO.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {

    String login; // gestire meglio
    String password;

    public boolean Login(String email, String password) {

        try {
            boolean login =  new LoginPostgresDAO().Login(email, password);
            if(login) {this.login=email; this.password=password;} // gestire meglio
            return  login;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    public void getWikiPage(String titolo) {//da finire
        try{
            new GetWikiDAO().getWikiPage(titolo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int register(String Nome, String Cognome, Object Genere, String Email, String Password) {
        System.out.println("Nome:" + Nome+"'"); //-1
        System.out.println("Cognome: " + Cognome); //-2
        System.out.println("Genere: " + Genere.toString());
        System.out.println("Email: " + Email); //-4 gia esiste //-6 non valida
        System.out.println("Password: " + Password); //-3
        //0 OK
        //-5 generale
        if (Nome.isBlank()){
            System.out.println("nome non valido");
            return -1;
        }
        if (Cognome.isBlank()){
            System.out.println("cognome non valida");
            return -2;
        }
        if (Password.isBlank()){
            System.out.println("password non valido");
            return -3;
        }
        //email controllata dal DB
        //genere è pre-impostato
        try{
            return new RegisterPostgerDAO().RegisterUser(Nome, Cognome, Genere.toString(), Email, Password);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -6;
        }
    }
}