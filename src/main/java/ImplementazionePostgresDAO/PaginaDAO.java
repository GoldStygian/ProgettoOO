package main.java.ImplementazionePostgresDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PaginaDAO implements main.java.DAO.PaginaDAO {

    @Override
    public HashMap<Integer, ArrayList<String>> getWikiPage(int idPagina) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM frase WHERE pagina = %d order by posizione".formatted(idPagina);
        ResultSet WikiPage = statement.executeQuery(query);

        HashMap<Integer, ArrayList<String>> Frasi = new HashMap<>(); // ci sta sempre un elemento nella pagina
        Integer index = 0;

        while(WikiPage.next()){
            index+=1;
            ArrayList<String> frase = new ArrayList<>();
            frase.add(WikiPage.getString("pagina"));
            frase.add(WikiPage.getString("posizione"));
            frase.add(WikiPage.getString("testo"));
            frase.add(WikiPage.getString("link"));
            frase.add(WikiPage.getString("linkpagina"));

            Frasi.put(index, frase);
        }
        System.out.println(Frasi);

        WikiPage.close();
        statement.close();
        con.close();

        return Frasi;
    }

    @Override
    public ArrayList<String> getWikiInfo(int idPagina) throws SQLException{

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();
        String query="SELECT * FROM pagina WHERE id_pagina = %d".formatted(idPagina);
        ResultSet result = statement.executeQuery(query);

        ArrayList<String> pagina_cercata = null;
        if (result.next()){
            pagina_cercata = new ArrayList<>();
            pagina_cercata.add(result.getString("titolo"));
            pagina_cercata.add(result.getString("generalita_autore"));
            pagina_cercata.add(result.getString("dataultimamodifica"));
            pagina_cercata.add(result.getString("datacreazione"));
        }

        return pagina_cercata;
    }

    @Override
    public void createPage(String titolo, String frase){
        Connection con = new ConnessionePostgesDAO().openConnection();



    }

}
