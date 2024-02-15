package main.java.ImplementazionePostgresDAO;

import main.java.Model.Frase;
import main.java.Model.Link;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class GetWikiDAO implements main.java.DAO.GetWikiDAO {

    @Override
    public HashMap<Integer, Frase> getWikiPage(int idPagina) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        //String query="SELECT posizione, testo, link FROM frase WHERE pagina IN (SELECT id_pagina FROM pagina WHERE titolo = '%s')".formatted(titolo);
        String query="SELECT posizione, testo, link FROM frase WHERE pagina = %d order by posizione".formatted(idPagina);
        ResultSet WikiPage = statement.executeQuery(query);

        HashMap<Integer, Frase> Frasi = new HashMap<Integer, Frase>(); // ci sta sempre un elemento nella pagina
        Integer index = 0;
        while(WikiPage.next()){
            Frase frase;
            index+=1;
            if (WikiPage.getBoolean("link")){
                frase = new Link(WikiPage.getString("testo"), WikiPage.getInt("posizione"));
            }else{
                frase = new Frase(WikiPage.getString("testo"), WikiPage.getInt("posizione"));
            }
            Frasi.put(index, frase);
        }
        System.out.println(Frasi);

        WikiPage.close();
        statement.close();
        con.close();

        return Frasi;
    }

}
