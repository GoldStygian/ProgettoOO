package main.java.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Pagina {

    private String titolo = new String();
    private String Generalita_Autore = new String();
    private String Data_Ultima_Modifica;
    private String Crezione_Pagina;
    private HashMap<Integer, Frase> Frasi;

    public Pagina(String titolo, String Generalita_Autore, String DataUltimaModifica, String Crezione_Pagina){
        this.titolo = titolo;
        this.Generalita_Autore = Generalita_Autore;
        this.Data_Ultima_Modifica = DataUltimaModifica;
        this.Crezione_Pagina = Crezione_Pagina;

    }

    public void AddFrase(){}
    public void AddFrasi(HashMap<Integer, ArrayList<String>> Frasi){

        this.Frasi = new HashMap<Integer, Frase>();
        for (Map.Entry<Integer, ArrayList<String>> entry : Frasi.entrySet()) {

            Frase frase;
            if ( Boolean.parseBoolean(entry.getValue().get(3)) ){
                frase = new Link(entry.getValue().get(2), Integer.parseInt(entry.getValue().get(1)));//testo //posizione
            }else{
                frase = new Frase(entry.getValue().get(2), Integer.parseInt(entry.getValue().get(1)));
            }

            this.Frasi.put(entry.getKey(), frase);

        }

    }

    public HashMap<Integer, Frase> getFrasi(){return Frasi;}

}