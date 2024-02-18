package main.java.ImplementazionePostgresDAO;

import main.java.DAO.WikiPageDAO;

import java.sql.*;

public class WikiPagePostgresDAO implements WikiPageDAO {

    @Override
    public String proponiInserimento(int idPagina, String email, String text, int posizione, boolean selected, String riferimentoLink) throws SQLException {
        Connection con = new ConnessionePostgesDAO().openConnection();
        String MessageReturn = new String();
        int linkValue;


        String query = "CALL operazioneutenterichiesta('%s'::VARCHAR(255), '%s'::TEXT, %d, 0::bit(1), %d, %d, 0::bit(1), %d)".formatted(email, text, posizione, idPagina, posizione, null);
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        /*if (selected) {
            String query = "SELECT id_pagina FROM pagina WHERE titolo = ?";
            try (PreparedStatement checkPageStatement = con.prepareStatement(query)) {
                checkPageStatement.setString(1, riferimentoLink);
                try (ResultSet checkPage = checkPageStatement.executeQuery()) {
                    if (!checkPage.next()) {
                        return "La pagina a cui la frase fa riferimento è inesistente";
                    }
                    linkValue = checkPage.getInt("id_pagina");
                }
            }
            String procedureCall = "{CALL operazioneutenterichiesta(?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement statement = con.prepareCall(procedureCall)) {
                statement.setString(1, email);
                statement.setString(2, text);
                statement.setInt(3, posizione);
                statement.setBoolean(4, false);
                statement.setInt(5, idPagina);
                statement.setInt(6, posizione);
                statement.setInt(7, linkValue);
                statement.execute();
            }
        } else {
            String procedureCall = "{CALL operazioneutenterichiesta(?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement statement = con.prepareCall(procedureCall)) {
                statement.setString(1, email);
                statement.setString(2, text);
                statement.setInt(3, posizione);
                statement.setString(4, selected ? "1" : "0");
                statement.setInt(5, idPagina);
                statement.setInt(6, posizione);
                statement.setBoolean(7, false);
                statement.setNull(8, Types.INTEGER);
                statement.execute();
            }
        }*/

        con.close();
        return MessageReturn;
    }
}
