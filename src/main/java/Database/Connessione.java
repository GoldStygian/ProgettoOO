package main.java.Database;

import java.sql.*;

public class Connessione {

    public Connessione() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://ep-black-cake-a2047v07.eu-central-1.aws.neon.tech:5432/Wiki";
            Connection con = DriverManager.getConnection(url, "filix820zec", "jlrdmw0OCXh2");
            System.out.println("[ ] Connessione OK \n");
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("[-] DB driver not found \n");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("[-] Connessione Fallita \n");
            System.out.println(e);
        }
    }

}