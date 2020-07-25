package com.belfoapps.recipeapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belfoapps.recipeapp.R;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {
    private static final String TAG = "StepsAdapter";

    /**
     * ************************************* Declarations ******************************************
     */
    private String[] mSteps;
    private Context context;

    /**
     * ************************************** Constructor ******************************************
     */
    public StepsAdapter(String[] mSteps, Context context) {
        this.mSteps = mSteps;
        this.context = context;
    }

    /**
     * ****************************************** Methods ******************************************
     */
    @NonNull
    @Override
    public StepsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StepsAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.steps_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.ViewHolder holder, int position) {
        holder.step.setText(mSteps[position]);

        //TODO: Long Press Copy Step
    }

    @Override
    public int getItemCount() {
        if (mSteps == null) return 0;
        else return mSteps.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView step;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            step = itemView.findViewById(R.id.step);
        }
    }
}
