package com.belfoapps.recipeapp.views.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.ActivityMainBinding;
import com.belfoapps.recipeapp.views.MainListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements MainListener {
    private static final String TAG = "MainActivity";

    /**
     * ************************************* Declarations ******************************************
     */
    private ActivityMainBinding mBinding;
    private NavController mNav;

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        if (savedInstanceState != null) {
            //TODO: Restore Data
        }

        //Set DrawerMenu
        setDrawerMenuCallbacks();

        //Init Navigation Component
        mNav = Navigation.findNavController(this, R.id.main_nav_host_fragment);
    }

    /**
     * **************************************** Save State *****************************************
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //TODO: Save UI State
    }

    /**
     * ****************************************** Methods ******************************************
     */
    private void setDrawerMenuCallbacks() {
        mBinding.navigation.setItemIconTintList(null);
        mBinding.navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                }

                return true;
            }
        });

        /*
        mBinding.openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.drawerMenu.openDrawer(GravityCompat.START);
            }
        });*/
    }

    /**
     * ******************************************* Events ******************************************
     */
    @Override
    public void openDrawer() {

    }

    @Override
    public void goToShoppingList() {
        mNav.navigate(R.id.go_to_shopping_list);
    }

    @Override
    public void goToRecipes(String mode, String category) {
        Bundle bundle = new Bundle();
        bundle.putString("mode", mode);
        bundle.putString("category", category);
        mNav.navigate(R.id.go_to_recipes, bundle);

    }

    @Override
    public void goToRecipe(String recipe_id) {
        Bundle bundle = new Bundle();
        bundle.putString("recipe_id", recipe_id);
        mNav.navigate(R.id.go_to_recipe, bundle);

    }

    @Override
    public void goToIngredients(String recipe_id) {
        Bundle bundle = new Bundle();
        bundle.putString("recipe_id", recipe_id);
        mNav.navigate(R.id.go_to_ingredients, bundle);
    }
}