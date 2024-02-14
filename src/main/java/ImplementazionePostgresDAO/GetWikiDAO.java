package main.java.ImplementazionePostgresDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;



        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);


public class GetWikiDAO implements main.java.DAO.GetWikiDAO {

    public HashMap<Integer, String> getWikiPage(String titolo) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT posizionem testo, link FROM frase WHERE pagina IN (SELECT id_pagina FROM pagina WHERE titolo = '%s')".formatted(titolo);
        ResultSet WikiPage = statement.executeQuery(query);

        HashMap<Integer, String> Frasi = new HashMap<Integer, String>(); // ci sta sempre un elemento nella pagina
        while(WikiPage.next()){

            Frasi.put("USA", "Washington DC");
            System.out.println(WikiPage.getString("testo"));
        }

        WikiPage.close();
        statement.close();
        con.close();

        return Frasi;
    }
}
