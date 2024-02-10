package main.java.Model;
import java.util.ArrayList;
import java.util.Date;
public class Pagina {

    String titolo = new String();
    String Generalita_Autore = new String();
    Date DataUltimaModifica;
    ArrayList<Frase> Frasi = new ArrayList<Frase>();

    public Pagina(String titolo, String Generalita_Autore, Date DataUltimaModifica){
        this.titolo = titolo;
        this.Generalita_Autore = Generalita_Autore;
        this.DataUltimaModifica = DataUltimaModifica;

    }

}
