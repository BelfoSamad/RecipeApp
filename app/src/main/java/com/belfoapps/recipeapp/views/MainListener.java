package com.belfoapps.recipeapp.views;

public interface MainListener {

    void openDrawer();

    void goToShoppingList();

    void goToRecipes(String mode, String category);

    void goToRecipe(String recipe_id);

    void goToIngredients(String recipe_id);
}
