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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.RecipesFragmentBinding;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.RecipesAdapter;
import com.belfoapps.recipeapp.viewmodels.RecipesViewModel;

import java.util.ArrayList;

public class RecipesFragment extends Fragment {
    private static final String TAG = "RecipesFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private RecipesViewModel mViewModel;
    private RecipesFragmentBinding mBinding;

    /**
     * ************************************** Constructor ******************************************
     */
    public static RecipesFragment newInstance() {
        return new RecipesFragment();
    }

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = RecipesFragmentBinding.inflate(inflater, container, false);

        //Init Page Name
        setPageTitle("Recipes");

        //Init Recipes
        //TODO: Get Recipes
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Recipe 1", "Category 1", R.drawable.recipe, 120, 2.4f));
        recipes.add(new Recipe("Recipe 2", "Category 1", R.drawable.recipe, 60, 4f));
        recipes.add(new Recipe("Recipe 3", "Category 1", R.drawable.recipe, 160, 3.4f));
        recipes.add(new Recipe("Recipe 4", "Category 1", R.drawable.recipe, 140, 2f));
        recipes.add(new Recipe("Recipe 3", "Category 1", R.drawable.recipe, 160, 3.4f));
        recipes.add(new Recipe("Recipe 4", "Category 1", R.drawable.recipe, 140, 2f));

        initRecyclerView(recipes);


        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
        mViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);

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
    private void setPageTitle(String page_title) {
        mBinding.pageTitle.setText(page_title);
    }

    private void initRecyclerView(ArrayList<Recipe> recipes) {
        RecipesAdapter adapter = new RecipesAdapter(recipes, getContext(), "LIST");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mBinding.recipesRecyclerview.setLayoutManager(manager);
        mBinding.recipesRecyclerview.setAdapter(adapter);
        mBinding.recipesRecyclerview.addItemDecoration(new RecipesItemDecoration());
    }

    private static class RecipesItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = 18;
            outRect.right = 18;
            outRect.bottom = 32;
        }
    }
}