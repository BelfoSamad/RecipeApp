package com.belfoapps.recipeapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.viewmodels.RecipeViewModel;

public class RecipeFragment extends Fragment {
    private static final String TAG = "RecipeFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private RecipeViewModel mViewModel;

    /**
     * ************************************** Constructor ******************************************
     */
    public static RecipeFragment newInstance() {
        return new RecipeFragment();
    }

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipe_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * **************************************** Save State *****************************************
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * ****************************************** Methods ******************************************
     */
}