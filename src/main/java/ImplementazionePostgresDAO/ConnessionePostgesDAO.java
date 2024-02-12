package main.java.ImplementazionePostgresDAO;

import main.java.DAO.ConnessioneDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessionePostgesDAO implements ConnessioneDAO {

    private String password =  "jlrdmw0OCXh2";
    private String user = "filix820zec";
    private String url = "jdbc:postgresql://ep-black-cake-a2047v07.eu-central-1.aws.neon.tech:5432/Wiki";

    @Override
    public Connection openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
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

    @Override
    public void closeConnection(Connection con) throws SQLException {
        con.close();
    }

}