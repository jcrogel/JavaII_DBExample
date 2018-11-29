package sample.models;

import sample.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private int id=0;
    private String name="";

    public Ingredient(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public static List<Ingredient> loadFromDB(){
        Connection conn = null;
        ArrayList<Ingredient> result = new ArrayList<Ingredient>();

        try {
            conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Ingredients");

            while(rs.next()){
                int id = rs.getInt("IngredientID");
                String str = rs.getString("IngredientName");

                result.add(new Ingredient(id, str));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /*

     */
}
