package com.belfoapps.recipeapp.views.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.RecipeFragmentBinding;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.IngredientsAdapter;
import com.belfoapps.recipeapp.ui.adapters.StepsAdapter;
import com.belfoapps.recipeapp.viewmodels.RecipeViewModel;

public class RecipeFragment extends Fragment {
    private static final String TAG = "RecipeFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private RecipeViewModel mViewModel;
    private RecipeFragmentBinding mBinding;


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //Getting Recipe Id
            String recipe_id = getArguments().getString("recipe_id");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = RecipeFragmentBinding.inflate(inflater, container, false);

        //go back
        mBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        //TODO: Get Recipe
        //Bind Recipe
        Recipe recipe = new Recipe("Recipe Title", "Category", R.drawable.recipe, 120, 2.5f, 6, null, null, null);
        mBinding.setRecipe(recipe);

        //init Ingredients RecyclerView
        //TODO: get the ingredients from the recipe object retrieved
        String[] ingredients = {"Ingredient 1", "Ingredient 2", "Ingredient 3"};
        initIngredientsRecyclerView(ingredients);

        //init Steps RecyclerView
        //TODO: get the steps from the recipe object retrieved
        String[] steps = {"Step 1", "Step 2", "Step 3"};
        initStepsRecyclerView(steps);

        return mBinding.getRoot();
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
    private void initStepsRecyclerView(String[] steps) {
        StepsAdapter mAdapter = new StepsAdapter(steps, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        mBinding.stepsRecyclerview.setLayoutManager(manager);
        mBinding.stepsRecyclerview.setAdapter(mAdapter);

        mBinding.stepsIndicator.attachToRecyclerView(mBinding.stepsRecyclerview);
    }

    private void initIngredientsRecyclerView(String[] ingredients) {
        IngredientsAdapter mAdapter = new IngredientsAdapter(ingredients, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mBinding.ingredientsRecyclerview.setLayoutManager(manager);
        mBinding.ingredientsRecyclerview.setAdapter(mAdapter);
        mBinding.ingredientsRecyclerview.addItemDecoration(new MyItemDecoration());
    }

    private static class MyItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
            super.getItemOffsets(outRect, itemPosition, parent);

            outRect.bottom = 8;
        }
    }
}