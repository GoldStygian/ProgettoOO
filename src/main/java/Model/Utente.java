package main.java.Model;

import java.util.ArrayList;

public class Utente {

    private String Email;
    private String Password;
    private String Nome;
    private String Cognome;
    private char genere;

    ArrayList<OperazioneUtente> Operazioni_Utente = new ArrayList<OperazioneUtente>();

    public Utente(String Email, String Password, String Nome, String Cognome, char genere){
        this.Nome=Nome;
        this.Email=Email;
        this.Password=Password;
        this.Cognome=Cognome;
        this.genere=genere;
    }

    public void print() {
        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);
        System.out.println("Nome: " + Nome);
        System.out.println("Cognome: " + Cognome);
        System.out.println("Genere: " + genere);
    }

    public String getEmail(){
        return Email;
    }

    public char getGenere() {
        return genere;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getNome() {
        return Nome;
    }

    public String getPassword() {
        return Password;
    }
    //public

}