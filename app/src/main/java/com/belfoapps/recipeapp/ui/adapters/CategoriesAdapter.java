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
import com.belfoapps.recipeapp.models.Category;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private static final String TAG = "CategoriesAdapter";

    /**
     * ************************************* Declarations ******************************************
     */
    private ArrayList<Category> categories;
    private Context context;

    /**
     * ************************************** Constructor ******************************************
     */
    public CategoriesAdapter(ArrayList<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    /**
     * ****************************************** Methods ******************************************
     */
    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        //TODO: Set Images By Glide/Picasso
        holder.image.setImageResource(categories.get(position).getImage());
        holder.title.setText(categories.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (categories == null) return 0;
        else return categories.size();
    }

    /**
     * **************************************** ViewHolder *****************************************
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);
        }
    }
}
