package com.belfoapps.recipeapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.models.Recipe;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    private static final String TAG = "RecipesAdapter";

    /**
     * ************************************* Declarations ******************************************
     */
    private ArrayList<Recipe> recipes;
    private Context context;

    /**
     * ************************************** Constructor ******************************************
     */
    public RecipesAdapter(ArrayList<Recipe> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    /**
     * ****************************************** Methods ******************************************
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipesAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(recipes.get(position).getTitle());
        holder.category.setText(recipes.get(position).getTitle());
        //TODO: Set Images By Glide/Picasso
        holder.image.setImageResource(recipes.get(position).getImage());
        holder.time.setText(recipes.get(position).getTime() + " min");
        holder.rating.setText(recipes.get(position).getRating() + "/5");
    }

    @Override
    public int getItemCount() {
        if (recipes == null) return 0;
        else return recipes.size();
    }

    /**
     * **************************************** ViewHolder *****************************************
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView category;
        private ImageView image;
        private TextView time;
        private TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recipe_title);
            category = itemView.findViewById(R.id.recipe_category);
            image = itemView.findViewById(R.id.recipe_image);
            time = itemView.findViewById(R.id.recipe_time);
            rating = itemView.findViewById(R.id.recipe_rating);
        }
    }
}
