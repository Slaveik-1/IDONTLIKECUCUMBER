package DbPichypido;

import java.sql.*;

public class Pichupido {
    private static Pichupido dbshechka = null;
    private Connection connection = null;
    private final String odin = "SELECT FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC FROM FOOD";
    private final String insertOne = "INSERT INTO FOOD(FOOD_NAME, FOOD_TYPE, FOOD_EXOTIC) VALUES (?,?,?)";

    private Pichupido(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost:9092/mem:testdb",
                    "user",
                    "pass");}
        catch (SQLException e) { e.printStackTrace(); }
    }
    private boolean checkConn() {
        try{ if(!(connection == null) && connection.isValid(1)) return true; }
        catch (SQLException e) { e.printStackTrace(); }
        return false;
    }


    public void closeConnection() {
        if(checkConn()) {
            try { connection.close(); }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public static Pichupido getDBInstance() {
        if(dbshechka == null)
            dbshechka = new Pichupido();
        return dbshechka;
    }

    public ResultSet getContents() {
        try {
            PreparedStatement polselecta = connection.prepareStatement(odin);
            return polselecta.executeQuery();
        }
        catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    public boolean insertRow(String name, Foodhell type, Boolean exotic) {
        try {
            PreparedStatement insertRow = connection.prepareStatement(insertOne);
            insertRow.setString(1, name);
            insertRow.setString(2, type.getFruitNameEng());
            if(exotic)
                insertRow.setInt(3, 1);
            else
                insertRow.setInt(3, 0);
            int a = insertRow.executeUpdate();
            return a > 0;
        }
        catch (SQLException e) { e.printStackTrace(); }
        return false;


    }}
