package sample;

import sample.models.Ingredient;
import sample.models.Recipes;

import java.util.List;

public class Controller {
    public void loadIngredients(){
       List<Ingredient> ingredients = Ingredient.loadFromDB();
       for (Ingredient i: ingredients){
           Recipes.getRecipesFromIngredient(i.getId());
           break;
       }
    }
}
