package main.java.Model;
import java.sql.Timestamp;
import java.util.Date;
public class OperazioneUtente {

    private int id_operazione;
    private Timestamp DataA;
    private Timestamp DataR;
    private String Testo;
    private boolean accettata;
    private boolean visionata;
    private boolean link;
    private int link_pagina;
    private String Utente;

    private boolean modifica;

    public OperazioneUtente(int id_operazione,Timestamp DataA, Timestamp DataR, String Testo, boolean accettata, boolean visionata,boolean modifica, boolean link, int link_pagina, String Utente){
        this.DataA = DataA;
        this.DataR = DataR;
        this.Testo = Testo;
        this.accettata = accettata;
        this.visionata = visionata;
        this.link = link;
        this.link_pagina = link_pagina;
        this.modifica = modifica;
        this.id_operazione = id_operazione;
        this.Utente = Utente;

    }

    public OperazioneUtente(int id_operazione, Timestamp DataR, String Testo, boolean accettata, boolean visionata,boolean modifica, boolean link, int link_pagina, String Utente){

        this.DataR = DataR;
        this.Testo = Testo;
        this.accettata = accettata;
        this.visionata = visionata;
        this.link = link;
        this.link_pagina = link_pagina;
        this.modifica = modifica;
        this.id_operazione = id_operazione;
        this.Utente = Utente;

    }

    public Timestamp getDataR() {
        return DataR;
    }

    public boolean getAccettata() {
        return accettata;
    }

    public boolean getVisionata() {
        return visionata;
    }

    public boolean getModifica() {
        return modifica;
    }

    public int getLink_pagina() {
        return link_pagina;
    }

    public String getTesto(){
        return Testo;
    }

    public boolean getLink(){
        return link;
    }

    public int getIdOperazione(){
        return id_operazione;
    }

    public String getUtente(){
        return Utente;
    }
}
