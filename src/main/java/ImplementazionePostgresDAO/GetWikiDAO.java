package main.java.ImplementazionePostgresDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetWikiDAO implements main.java.DAO.GetWikiDAO {



    public void getWikiPage(String titolo) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM frase WHERE pagina IN (SELECT id_pagina FROM pagina WHERE titolo = '%s')".formatted(titolo);
        ResultSet WikiPage = statement.executeQuery(query);

        while(WikiPage.next()){
            System.out.println(WikiPage.getString("testo"));
        }

        WikiPage.close();
        statement.close();
        con.close();

    }
}
