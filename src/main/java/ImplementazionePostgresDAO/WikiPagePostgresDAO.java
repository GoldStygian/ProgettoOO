package main.java.ImplementazionePostgresDAO;

import main.java.DAO.WikiPageDAO;

import java.sql.*;

public class WikiPagePostgresDAO implements WikiPageDAO {

    @Override
    public String proponiInserimento(int idPagina, String email, String text, int posizione, boolean selected, String riferimentoLink) throws SQLException {

        Connection con = new ConnessionePostgesDAO().openConnection();
        String MessageReturn = new String();
        String query;

        if (selected){
            int linkValue;
            query = "SELECT id_pagina FROM pagina WHERE titolo = ?";
            try (PreparedStatement checkPageStatement = con.prepareStatement(query)) {
                checkPageStatement.setString(1, riferimentoLink);
                try (ResultSet checkPage = checkPageStatement.executeQuery()) {
                    if (!checkPage.next()) {
                        con.close();
                        return MessageReturn += "La pagina a cui la frase fa riferimento è inesistente<br>";
                    }
                    linkValue = checkPage.getInt("id_pagina");
                    checkPage.close();
                }
                checkPageStatement.close();
            }

            query = "CALL operazioneutenterichiesta('%s'::VARCHAR(255), '%s'::TEXT, %d, 0::bit(1), %d, %d, 1::bit(1), %d)".formatted(email, text, posizione, idPagina, posizione, linkValue);


        }else{
            query = "CALL operazioneutenterichiesta('%s'::VARCHAR(255), '%s'::TEXT, %d, 0::bit(1), %d, %d, 0::bit(1), %d)".formatted(email, text, posizione, idPagina, posizione, null);

        }

        Statement stm = con.createStatement();
        boolean result = stm.execute(query);

        System.out.println(result);
        if (!result){ //la procedura non deve ritornare valori
            MessageReturn = "Inserimento proposto con successo<br>";
        }else{
            ResultSet rs = stm.getResultSet();
            System.out.println(rs);
        }

        con.close();
        stm.close();
        return MessageReturn;
    }
}
