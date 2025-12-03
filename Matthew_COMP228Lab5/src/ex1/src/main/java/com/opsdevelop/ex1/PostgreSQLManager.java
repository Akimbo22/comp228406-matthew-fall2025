package com.opsdevelop.ex1;

// Matthew Elliott - 301424215
// Lab 05
// December 3, 2025

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLManager {
    private final String connectionURL;
    private final String tableName = "comp228_demo";

    // Creating the connectionURL to Supabase
    public PostgreSQLManager(String url, int port, String dbName, String user, String password) {
        this.connectionURL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?user=postgres.vczqwyqrsmuzcgoilyvk&password=Sch0oLw0rkg@m3r5$";
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(connectionURL);
    }


    // Adding the required columns to the table
    public boolean addRecord(int game_id, String game_title, int player_id,
                             String first_name, String last_name, String address,
                             String postal_code, String province, String phone_number,
                             int player_game_id, String playing_date, int score) {
        String query = "INSERT INTO " + tableName + " (game_id, game_title, player_id, first_name, last_name, " +
                "address, postal_code, province, phone_number, player_game_id, playing_date, score) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, game_id);
            stmt.setString(2, game_title);
            stmt.setInt(3, player_id);
            stmt.setString(4, first_name);
            stmt.setString(5, last_name);
            stmt.setString(6, address);
            stmt.setString(7, postal_code);
            stmt.setString(8, province);
            stmt.setString(9, phone_number);
            stmt.setInt(10, player_game_id);
            stmt.setString(11, playing_date);
            stmt.setInt(12, score);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PlayerRecord> getAllRecords() {
        String query = "SELECT * FROM comp228_demo";
        List<PlayerRecord> records = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                records.add(new PlayerRecord(rs.getInt("game_id"), rs.getString("game_title"),
                        rs.getInt("player_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("address"),
                        rs.getString("postal_code"), rs.getString("province"),
                        rs.getString("phone_number"), rs.getInt("player_game_id"),
                        rs.getString("playing_date"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
