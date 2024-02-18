package main.java.ImplementazionePostgresDAO;

import main.java.DAO.ConnessioneDAO;

//sql
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//file
import java.util.ArrayList;
import java.util.Scanner;


public class ConnessionePostgesDAO implements ConnessioneDAO {

    private String password;
    private String user;
    private String url;

    @Override
    public Connection openConnection() {

        ArrayList<String> Credenziali = new ArrayList<>();
        String filePath = "src\\main\\java\\ImplementazionePostgresDAO\\credenziali.txt";
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Credenziali.add(line);
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://"+ Credenziali.get(0), Credenziali.get(1), Credenziali.get(2));
            System.out.println("[ ] Connessione aperta");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("[-] DB driver not found \n");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("[-] Connessione Fallita \n");
            System.out.println(e);
        }
        return null;
    }

}