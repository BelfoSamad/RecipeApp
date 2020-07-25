package com.belfoapps.recipeapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belfoapps.recipeapp.R;

import net.igenius.customcheckbox.CustomCheckBox;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {
    private static final String TAG = "IngredientsAdapter";

    /**
     * ************************************* Declarations ******************************************
     */
    private String[] mIngredients;
    private Context context;

    /**
     * ************************************** Constructor ******************************************
     */
    public IngredientsAdapter(String[] mIngredients, Context context) {
        this.mIngredients = mIngredients;
        this.context = context;
    }

    /**
     * ****************************************** Methods ******************************************
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sl_ingredients_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ingredient.setText(mIngredients[position]);

        //TODO: Manage Checkbox
    }

    @Override
    public int getItemCount() {
        if (mIngredients == null) return 0;
        else return mIngredients.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ingredient;
        CustomCheckBox checkbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredient = itemView.findViewById(R.id.ingredient);
            checkbox = itemView.findViewById(R.id.ingredient_checkbox);
        }
    }
}
