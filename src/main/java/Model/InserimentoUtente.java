package main.java.Model;

import java.util.Date;

public class InserimentoUtente extends OperazioneUtente{

    int posizione;
    public InserimentoUtente(Date DataA, Date DataR, String Testo, boolean accettata, boolean visionata, boolean link, Pagina link_pagina, int posizione){
        super(DataA,DataR,Testo,accettata,visionata,link,link_pagina);
        this.posizione = posizione;
    }


}
