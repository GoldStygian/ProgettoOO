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


    public void OperazioneUtente(Date DataA, Date DataR, String Testo, boolean accettata, boolean visionata, boolean link, Pagina link_pagina){
        this.DataA = DataA;
        this.DataR = DataR;
        this.Testo = Testo;
        this.accettata = accettata;
        this.visionata = visionata;
        this.link = link;
        this.link_pagina = link_pagina;

    }

}
