package com.belfoapps.recipeapp.views.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.ActivitySearchResultsBinding;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.RecipesAdapter;
import com.belfoapps.recipeapp.utils.SuggestionsProvider;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    /**
     * ************************************* Declarations ******************************************
     */
    private ActivitySearchResultsBinding mBinding;


    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySearchResultsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //TODO: Validate query and do search
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            //Save Query as Suggestion
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SuggestionsProvider.AUTHORITY, SuggestionsProvider.MODE);
            suggestions.saveRecentQuery(query, null);

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
        }

        //TODO: Init UI
        //Init Filters
        initFilters();
    }

    /**
     * **************************************** Save State *****************************************
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * ****************************************** Methods ******************************************
     */
    private void setPageTitle(String page_title) {
        mBinding.pageTitle.setText(page_title);
    }

    private void initFilters() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
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
        RecipesAdapter adapter = new RecipesAdapter(recipes, this, "LIST");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mBinding.resultsRecyclerview.setLayoutManager(manager);
        mBinding.resultsRecyclerview.setAdapter(adapter);
        mBinding.resultsRecyclerview.addItemDecoration(new RecipesItemDecoration());
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