package com.belfoapps.recipeapp.models;

import java.util.ArrayList;

public class Recipe {
    private String title;
    private String category;
    private int image;
    private int time;
    private float rating;
    private int servings;
    private String video_url;
    private String[] ingredients;
    private String[] steps;

    //Featured Recipe
    public Recipe(String title, int image) {
        this.title = title;
        this.image = image;
    }

    //Recipe
    public Recipe(String title, String category, int image, int time, float rating) {
        this.title = title;
        this.category = category;
        this.image = image;
        this.time = time;
        this.rating = rating;
    }

    //Full Recipe
    public Recipe(String title, String category, int image, int time, float rating, int servings, String video_url, String[] ingredients, String[] steps) {
        this.title = title;
        this.category = category;
        this.image = image;
        this.time = time;
        this.rating = rating;
        this.servings = servings;
        this.video_url = video_url;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }

    public int getTime() {
        return time;
    }

    public float getRating() {
        return rating;
    }

    public int getServings() {
        return servings;
    }

    public String getVideo_url() {
        return video_url;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getSteps() {
        return steps;
    }
}
