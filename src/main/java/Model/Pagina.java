package main.java.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Pagina {

    private String titolo = new String();
    private String Generalita_Autore = new String();
    private Date Data_Ultima_Modifica;
    private Date Crezione_Pagina;
    private HashMap<Integer, Frase> Frasi;

    public Pagina(String titolo, String Generalita_Autore, Date DataUltimaModifica, Date Crezione_Pagina){
        this.titolo = titolo;
        this.Generalita_Autore = Generalita_Autore;
        this.Data_Ultima_Modifica = DataUltimaModifica;
        this.Crezione_Pagina = Crezione_Pagina;

    }

    public void AddFrase(){}
    public void AddFrasi(HashMap<Integer, Frase> Frasi){
        this.Frasi=Frasi;
    }

    public HashMap<Integer, Frase> getFrasi(){return Frasi;}

}