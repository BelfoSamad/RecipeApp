package com.belfoapps.recipeapp.models;

public class Recipe {
    private String title;
    private String category;
    private int image;
    private int time;
    private float rating;

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
}
