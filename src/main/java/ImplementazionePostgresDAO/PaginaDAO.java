package main.java.ImplementazionePostgresDAO;

import java.sql.*;
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
        //System.out.println(Frasi);

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
            pagina_cercata.add(result.getString("emailautore"));
            pagina_cercata.add(result.getString("generalita_autore"));
            pagina_cercata.add(result.getString("dataultimamodifica"));
            pagina_cercata.add(result.getString("datacreazione"));
            pagina_cercata.add(result.getString("id_pagina"));
        }

        return pagina_cercata;
    }

    @Override
    public String createPage(String email, String titolo, String frase, boolean link, String TitoloLink)throws SQLException{
        Connection con = new ConnessionePostgesDAO().openConnection();
        String MessageReturn = new String();
        String query;

        if (link){
                query = "SELECT id_pagina FROM pagina WHERE titolo = ?";
                PreparedStatement stm = con.prepareStatement(query);
                stm.setString(1, TitoloLink);
                ResultSet exist = stm.executeQuery();

                if (!exist.next()) {
                    con.close();
                    stm.close();
                    exist.close();
                    return MessageReturn += "La pagina a cui la frase fa riferimento è inesistente<br>";
                }

                query = "CALL creazionepagina('%s'::VARCHAR(255), '%s'::VARCHAR(255), '%s'::TEXT, 1::bit(1), '%s'::VARCHAR(255), %d)".formatted(titolo, email, frase, TitoloLink, 1);

                stm.close();
                exist.close();
        }else{

            query = "CALL creazionepagina('%s'::VARCHAR(255), '%s'::VARCHAR(255), '%s'::TEXT, 0::bit(1), '%s'::VARCHAR(255), %d)".formatted(titolo, email, frase, null, 1);

        }

        Statement stm = con.createStatement();
        boolean result = stm.execute(query);

        if (!result){ //la procedura non deve ritornare valori
            MessageReturn = "Pagina creata con successo<br>";
        }else{
            ResultSet rs = stm.getResultSet();
            //System.out.println(rs);
        }

        return MessageReturn;
    }

    @Override
    public ArrayList<ArrayList<String>> getMyPage(String email) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement stm = con.createStatement();
        String query = "SELECT * FROM pagina WHERE emailautore = '%s'".formatted(email);
        ResultSet rs = stm.executeQuery(query);

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while (rs.next()){
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(rs.getString("id_pagina"));
            tmp.add(rs.getString("titolo"));
            result.add(tmp);
        }

        con.close();
        stm.close();
        rs.close();
        return result;

    }

    @Override
    public ArrayList<ArrayList<String>> getStroicitaSpecifica(int idPagina, String data) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement stm = con.createStatement();

        String query;

        if(data.isEmpty() || data.equals("null")) {
            query = "SELECT * FROM storicita_totale WHERE id_pagina = %d ORDER BY posizione\n".formatted(idPagina);
        }else{
            query = "SELECT * FROM storicita_totale WHERE id_pagina = %d AND data_accettazione <= '%s' ORDER BY posizione\n".formatted(idPagina, data);
        }

        ResultSet rs = stm.executeQuery(query);

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while (rs.next()){
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(rs.getString("testo"));
            tmp.add(rs.getString("posizione"));
            result.add(tmp);
        }

        con.close();
        stm.close();
        rs.close();
        return result;
    }

    @Override
    public ArrayList<String> getDateAvailable(int idPagina) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement stm = con.createStatement();
        String query = "SELECT DISTINCT data_accettazione FROM storicita_totale WHERE data_accettazione IS NOT NULL AND id_pagina = %d order by data_accettazione DESC".formatted(idPagina);
        ResultSet rs = stm.executeQuery(query);

        ArrayList<String> result = new ArrayList<>();
        while (rs.next()){
            result.add(rs.getString("data_accettazione"));
        }

        if (result.isEmpty()) {
            return null;
        }else{
            return result;
        }

    }

}
