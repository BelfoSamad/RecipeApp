package com.belfoapps.recipeapp.views.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.SearchResultsFragmentBinding;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.RecipesAdapter;
import com.belfoapps.recipeapp.viewmodels.SearchResultsViewModel;
import com.belfoapps.recipeapp.views.MainListener;

import java.util.ArrayList;

public class SearchResultsFragment extends Fragment {
    private static final String TAG = "SearchResultsFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private SearchResultsViewModel mViewModel;
    private SearchResultsFragmentBinding mBinding;
    private MainListener listener;
    private String query;

    /**
     * ************************************** Constructor ******************************************
     */
    public static SearchResultsFragment newInstance() {
        return new SearchResultsFragment();
    }

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (MainListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement HomeFragmentEvents");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            query = getArguments().getString("query");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = SearchResultsFragmentBinding.inflate(inflater, container, false);

        //Init Page Name
        setPageTitle("Search For: " + query);

        //TODO: doMySearch(query);
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Recipe 1", "Category 1", R.drawable.recipe, 120, 2.4f));
        recipes.add(new Recipe("Recipe 2", "Category 1", R.drawable.recipe, 60, 4f));
        recipes.add(new Recipe("Recipe 3", "Category 1", R.drawable.recipe, 160, 3.4f));
        recipes.add(new Recipe("Recipe 4", "Category 1", R.drawable.recipe, 140, 2f));
        recipes.add(new Recipe("Recipe 3", "Category 1", R.drawable.recipe, 160, 3.4f));
        recipes.add(new Recipe("Recipe 4", "Category 1", R.drawable.recipe, 140, 2f));

        initSearchResults(recipes);

        //Init Search Filter
        initFilters();

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SearchResultsViewModel.class);
        // TODO: Use the ViewModel
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
    private void setPageTitle(String page_title) {
        mBinding.pageTitle.setText(page_title);
    }

    private void initFilters() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.category, android.R.layout.simple_spinner_item);
        //TODO: Custom Spinner

        //Set Adapter
        mBinding.filterCategory.setAdapter(adapter);

        /*
        mBinding.filterCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchResultsActivity.this, "Filter Search", Toast.LENGTH_SHORT).show();
                //TODO: Filter Search
            }
        });*/
    }

    private void initSearchResults(ArrayList<Recipe> recipes) {
        RecipesAdapter adapter = new RecipesAdapter(recipes, getContext(), "LIST");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mBinding.resultsRecyclerview.setLayoutManager(manager);
        mBinding.resultsRecyclerview.setAdapter(adapter);
        mBinding.resultsRecyclerview.addItemDecoration(new SearchResultsFragment.RecipesItemDecoration());
    }

    private void filterSearchResults(ArrayList<Recipe> recipes) {

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