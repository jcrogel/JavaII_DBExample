package sample.models;

import sample.DBConnection;

import java.sql.*;
import java.util.List;

public class Recipes {

    public static List<Recipes> getRecipesFromIngredient(int iid){
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            String qry = "select RecipeTitle from Recipes," +
                    " Recipe_Ingredients where" +
                    " Recipes.RecipeID=Recipe_Ingredients.RecipeID and" +
                    " Recipe_Ingredients.IngredientID=?;";
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setInt(1, iid);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String title = rs.getString("RecipeTitle");

                System.out.println(String.format("Found: %s", title));

            }
            System.out.println(rs);

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


        // TODO: Remove line below
        return null;
    }
}
