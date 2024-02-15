package main.java.Model;
import java.util.Date;
public class OperazioneUtente {

    private Date DataA;
    private Date DataR;
    private String Testo;
    private boolean accettata;
    private boolean visionata;
    private boolean link;
    private Pagina link_pagina;

    private boolean modifica;

    public OperazioneUtente(Date DataA, Date DataR, String Testo, boolean accettata, boolean visionata,boolean modifica, boolean link, Pagina link_pagina){
        this.DataA = DataA;
        this.DataR = DataR;
        this.Testo = Testo;
        this.accettata = accettata;
        this.visionata = visionata;
        this.link = link;
        this.link_pagina = link_pagina;
        this.modifica = modifica;

    }

    public OperazioneUtente(Date DataR, boolean accettata, boolean visionata, boolean modifica){
        this.DataR = DataR;
        this.accettata = accettata;
        this.visionata = visionata;
        this.modifica = modifica;

    }

    public Date getDataA() {
        return DataA;
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


}
