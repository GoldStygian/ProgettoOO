package main.java.Model;

import java.util.ArrayList;

public class Autore extends Utente{

    private ArrayList<Pagina> Pagine = new ArrayList<Pagina>();

    private ArrayList<Notifica> Notifiche = new ArrayList<Notifica>();

    public Autore(String Email, String Password, String Nome, String Cognome, char genere) {
        super(Email, Password, Nome, Cognome, genere);

    }

    public void addPagina(){}

    public void addNotifica(){}

}
