package main.java.Model;

public class Utente {

    private String Email;
    private String Password;
    private String Nome;
    private String Cognome;
    private char genere;

    public Utente(String Email, String Password, String Nome, String Cognome, char genere){
        this.Nome=Nome;
        this.Email=Email;
        this.Password=Password;
        this.Cognome=Cognome;
        this.genere=genere;
    }

    public void print(){
        System.out.println(Email);
    }
}