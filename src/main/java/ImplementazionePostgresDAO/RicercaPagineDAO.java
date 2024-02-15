package main.java.ImplementazionePostgresDAO;

import java.sql.*;
import java.util.ArrayList;

public class RicercaPagineDAO implements main.java.DAO.RicercaPagineDAO {

    /*
    public ArrayList<ArrayList<String>> SearchPage(String ricerca) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM trovapagina('%s')".formatted(ricerca);
        ResultSet idPagine = statement.executeQuery(query);

        //-1 ritorna se non trova pagine
        // '' ritorna tutte le pagine

        idPagine.next();
        String idPagineReturn = idPagine.getString("trovapagina");
        if (idPagineReturn.equals("-1")){
            idPagine.close();
            statement.close();
            con.close();
            return null;
        }else {

            ArrayList<ArrayList<String>> DataPages = new ArrayList<>();

            Statement statement2 = con.createStatement();
            String query2="SELECT titolo, generalita_autore, dataultimamodifica FROM pagina WHERE id_pagina = %s";

            String[] pagina = idPagineReturn.split("-");
            for (String part : pagina) {
                ResultSet data = statement.executeQuery(query2.formatted(part));
                System.out.println("[ ] "+query2.formatted(part));

                ArrayList<String> dataList = new ArrayList<>();
                while(data.next()){
                    dataList.add(data.getString("titolo"));
                    dataList.add(data.getString("generalita_autore"));
                    dataList.add(data.getString("dataultimamodifica"));
                }
                DataPages.add(dataList);
            }

            idPagine.close();
            statement.close();
            con.close();
            return DataPages;

        }

    }*/

    public ArrayList<ArrayList<String>> SearchPage(String ricerca) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        Statement statement = con.createStatement();

        String query="SELECT * FROM trovapagina('%s')".formatted(ricerca);
        ResultSet idPagine = statement.executeQuery(query);

        //-1 ritorna se non trova pagine
        // '' ritorna tutte le pagine

        idPagine.next();
        String idPagineReturn = idPagine.getString("trovapagina");
        if (idPagineReturn.equals("-1")){
            idPagine.close();
            statement.close();
            con.close();
            return null;
        }else {

            ArrayList<ArrayList<String>> DataPages = new ArrayList<>();

            Statement statement2 = con.createStatement();
            String query2="SELECT * FROM pagina WHERE id_pagina = %s";

            String[] pagina = idPagineReturn.split("-");
            for (String part : pagina) {
                ResultSet data = statement.executeQuery(query2.formatted(part));
                System.out.println("[ ] "+query2.formatted(part));

                ArrayList<String> dataList = new ArrayList<>();
                while(data.next()){
                    dataList.add(data.getString("titolo"));
                    dataList.add(data.getString("generalita_autore"));
                    dataList.add(data.getString("dataultimamodifica"));
                    dataList.add(data.getString("id_pagina"));
                }
                DataPages.add(dataList);
            }

            idPagine.close();
            statement.close();
            con.close();
            return DataPages;

        }

    }



}
