package main.java.Model;

import java.util.ArrayList;

public class Frase {

    private String Testo = new String();
    int posizione;

    private InserimentoAutore inserimentoAutore = null;
    private ArrayList<ModificaAutore> ModificheAutore = new ArrayList<ModificaAutore>();
    private InserimentoUtente inserimentoUtente = null;
    private ArrayList<ModificaUtente> ModificheUtente = new ArrayList<ModificaUtente>();

    public Frase(String Testo, int posizione){
        this.Testo = Testo;
        this.posizione = posizione;
    }

    public void AddModifica(){}

    public void AddInserimento(){}



}
