package main.java.Model;

import java.util.ArrayList;

public class Frase {

    private final String Testo;
    private final int posizione;
    private final InserimentoAutore inserimentoAutore = null;
    private ArrayList<ModificaAutore> ModificheAutore = new ArrayList<ModificaAutore>();
    private final InserimentoUtente inserimentoUtente = null;
    private ArrayList<ModificaUtente> ModificheUtente = new ArrayList<ModificaUtente>();

    public Frase(String Testo, int posizione){
        this.Testo = Testo;
        this.posizione = posizione;
    }

    public String getText(){
        return this.Testo;
    }

    public void AddModifica(){}

    public void AddInserimentoUtente(){}

    public ArrayList<String> getData(){

        ArrayList<String> Data = new ArrayList<>();
        Data.add(String.valueOf(posizione));
        Data.add(Testo);

        return Data;
    }

    public int getPosizione(){
        return posizione;
    }




}
