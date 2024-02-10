package GUI;
import Model.Utente;

public class Main {
    public static void main(String[] args) {
        System.out.println("[] start");

        Utente u1 = new Utente("email1", "pass1", "Antonio", "Iodice", 'M');
        u1.print();
    }
}