package com.belfoapps.recipeapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.models.Recipe;

import java.util.ArrayList;

public class FeaturedAdapter extends BaseAdapter {
    private static final String TAG = "FeaturedAdapter";

    /**
     * ************************************* Declarations ******************************************
     */
    private ArrayList<Recipe> recipes;
    private Context context;

    /**
     * ************************************** Constructor ******************************************
     */
    public FeaturedAdapter(ArrayList<Recipe> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    /**
     * ****************************************** Methods ******************************************
     */
    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.featured_item, parent, false);
        }

        Recipe currentRecipe = (Recipe) getItem(position);

        //Set UI
        //TODO: Set Images By Glide/Picasso
        ((ImageView) convertView.findViewById(R.id.featured_image)).setImageResource(currentRecipe.getImage());
        ((TextView) convertView.findViewById(R.id.featured_title)).setText(currentRecipe.getTitle());

        return convertView;
    }
}
