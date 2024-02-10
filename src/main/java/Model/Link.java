package main.java.Model;

import java.util.ArrayList;

public class Link extends Frase{

    private ArrayList<Pagina> Pagine_linkate = new ArrayList<Pagina>();

    public  Link(String testo, int posizione){
        super(testo,posizione);
    }

}
