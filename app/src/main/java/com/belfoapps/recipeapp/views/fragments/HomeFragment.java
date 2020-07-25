package com.belfoapps.recipeapp.views.fragments;

import android.app.SearchManager;
import android.content.Context;
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.HomeFragmentBinding;
import com.belfoapps.recipeapp.models.Category;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.CategoriesAdapter;
import com.belfoapps.recipeapp.ui.adapters.FeaturedAdapter;
import com.belfoapps.recipeapp.ui.adapters.RecipesAdapter;
import com.belfoapps.recipeapp.viewmodels.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private HomeViewModel mViewModel;
    private HomeFragmentBinding mBinding;

    /**
     * ************************************** Constructor ******************************************
     */
    public static HomeFragment newInstance() {
        return new HomeFragment();
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

        mBinding = HomeFragmentBinding.inflate(inflater, container, false);

        //Init Featured
        //TODO: Get Featured Recipes
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Recipe 1", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 2", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 3", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 4", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 5", R.drawable.recipe));
        initFeatured(recipes);

        //Init Categories
        //TODO: Get Categories
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Category 1", R.drawable.profile));
        categories.add(new Category("Category 2", R.drawable.profile));
        categories.add(new Category("Category 3", R.drawable.profile));
        categories.add(new Category("Category 4", R.drawable.profile));
        categories.add(new Category("Category 5", R.drawable.profile));
        initCategoriesRecyclerView(categories);

        //Init Recent Recipes
        //TODO: Get Recent Recipes
        ArrayList<Recipe> recent_recipes = new ArrayList<>();
        recent_recipes.add(new Recipe("Recipe 1", "Category 1", R.drawable.recipe, 120, 2.4f));
        recent_recipes.add(new Recipe("Recipe 2", "Category 1", R.drawable.recipe, 60, 4f));
        recent_recipes.add(new Recipe("Recipe 3", "Category 1", R.drawable.recipe, 160, 3.4f));
        recent_recipes.add(new Recipe("Recipe 4", "Category 1", R.drawable.recipe, 140, 2f));
        initRecentRecipesRecyclerView(recent_recipes);

        //Init Saved Recipes
        //TODO: Get Saved Recipes
        initSavedRecipesRecyclerView(recent_recipes);

        //Init Search
        initSearchView();

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
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
    private void initSearchView() {
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        mBinding.searchBar.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        // Do not iconify the widget; expand it by default
        mBinding.searchBar.setIconifiedByDefault(false);
        // Enabel Submit Button for the user
        mBinding.searchBar.setSubmitButtonEnabled(true);
        // Enable the ability to refine the suggestions
        mBinding.searchBar.setQueryRefinementEnabled(true);
    }

    private void initFeatured(ArrayList<Recipe> recipes) {
        FeaturedAdapter adapter = new FeaturedAdapter(recipes, getContext());
        mBinding.featured.setAdapter(adapter);
        mBinding.featured.startFlipping();
    }

    private void initCategoriesRecyclerView(ArrayList<Category> categories) {
        CategoriesAdapter adapter = new CategoriesAdapter(categories, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        mBinding.categoriesRecyclerview.setLayoutManager(manager);
        mBinding.categoriesRecyclerview.setAdapter(adapter);
        mBinding.categoriesRecyclerview.addItemDecoration(new CategoryItemDecoration());
    }

    private void initSavedRecipesRecyclerView(ArrayList<Recipe> recipes) {
        RecipesAdapter adapter = new RecipesAdapter(recipes, getContext(), "LIST");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mBinding.savedRecyclerview.setLayoutManager(manager);
        mBinding.savedRecyclerview.setAdapter(adapter);
        mBinding.savedRecyclerview.addItemDecoration(new RecipesItemDecoration());
    }

    private void initRecentRecipesRecyclerView(ArrayList<Recipe> recipes) {
        RecipesAdapter adapter = new RecipesAdapter(recipes, getContext(), "LIST");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mBinding.recentRecyclerview.setLayoutManager(manager);
        mBinding.recentRecyclerview.setAdapter(adapter);
        mBinding.recentRecyclerview.addItemDecoration(new RecipesItemDecoration());
    }

    /**
     * ************************************ Item Decorations ***************************************
     */
    private static class CategoryItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = 16;
        }
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