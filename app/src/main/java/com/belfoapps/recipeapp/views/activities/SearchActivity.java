package com.belfoapps.recipeapp.views.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.ActivitySearchBinding;
import com.belfoapps.recipeapp.utils.SuggestionsProvider;
import com.belfoapps.recipeapp.views.MainListener;

public class SearchActivity extends AppCompatActivity implements MainListener {
    private static final String TAG = "SearchActivity";

    /**
     * ************************************* Declarations ******************************************
     */
    private ActivitySearchBinding mBinding;
    private NavController mNav;

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //Init Navigation Component
        mNav = Navigation.findNavController(this, R.id.search_nav_host_fragment);

        //TODO: Validate query and do search
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            //Save Query as Suggestion
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SuggestionsProvider.AUTHORITY, SuggestionsProvider.MODE);
            suggestions.saveRecentQuery(query, null);

            Bundle bundle = new Bundle();
            bundle.putString("query", query);
            mNav.setGraph(R.navigation.search_nav_graph, bundle);
        }
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
    @Override
    public void openDrawer() {
        //Not Used
    }

    @Override
    public void goToShoppingList() {
        //Not Used
    }

    @Override
    public void goToRecipes(String mode, String category) {
        //Not Used
    }

    @Override
    public void goToRecipe(String recipe_id) {
        Bundle args = new Bundle();
        args.putString("recipe_id", recipe_id);
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
        mNav.navigate(R.id.go_to_recipe_from_search, args);
    }

    @Override
    public void goToIngredients(String recipe_id) {
        //Not Used
    }

}