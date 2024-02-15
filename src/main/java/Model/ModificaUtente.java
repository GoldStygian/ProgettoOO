package main.java.Model;

import java.util.Date;

public class ModificaUtente extends OperazioneUtente{


    public ModificaUtente(Date DataA, Date DataR, String Testo, boolean accettata, boolean visionata, boolean link, Pagina link_pagina, int posizione){
        super(DataA,DataR,Testo,accettata,visionata,link,link_pagina);

    }

    public ModificaUtente( Date DataR, boolean accettata, boolean visionata){
        super(DataR,accettata,visionata);

    }

}
