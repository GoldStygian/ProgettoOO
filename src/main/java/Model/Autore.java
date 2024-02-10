package main.java.Model;

import java.util.ArrayList;

public class Autore extends Utente{

    private ArrayList<Pagina> Pagine = new ArrayList<Pagina>();

    public Autore(String Email, String Password, String Nome, String Cognome, char genere) {
        super(Email, Password, Nome, Cognome, genere);

    }

    public void addPagina(){}

}
