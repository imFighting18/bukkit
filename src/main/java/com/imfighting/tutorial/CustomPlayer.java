package com.imfighting.tutorial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {

    private UUID uuid;
    private String rank;
    private int coins;
    private Main main;

    public CustomPlayer(Main main,UUID uuid) throws SQLException {
        this.uuid = uuid;
        this.main = main;

            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("SELECT RANK, COINS FROM " +
                    "teste WHERE UUID = ?");
            statement.setString(1, uuid.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                rank = rs.getString("RANK");
                coins = rs.getInt("COINS");
            } else {
                rank = "MEMBRO";
                coins = 0;
                PreparedStatement statement1 = main.getDatabase().getConnection().prepareStatement("INSERT INTO teste" +
                        " (ID, UUID, RANK, COINS) VALUES (" +
                        "default,"+
                        "'"+ uuid + "'," +
                        "'" + rank + "'," +
                        coins + ");");
                statement1.executeUpdate();
            }
    }

    public void setRank(String rank) {
        this.rank = rank;
        try {
            PreparedStatement stat = main.getDatabase().getConnection().prepareStatement("UPDATE teste SET RANK = ? " +
                    "WHERE UUID = ?;");
            stat.setString(1, rank);
            stat.setString(2, uuid.toString());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCoins(int coins) {
        this.coins = coins;
        try {
            PreparedStatement stat = main.getDatabase().getConnection().prepareStatement("UPDATE teste SET COINS = ? " +
                    "WHERE UUID = ?;");
            stat.setString(1, rank);
            stat.setString(2, uuid.toString());
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getRank() {
        return rank;
    }
    public int getCoins() {
        return coins;
    }
}
