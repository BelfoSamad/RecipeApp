package com.belfoapps.recipeapp.views.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.belfoapps.recipeapp.R;

public class RecipeActivity extends AppCompatActivity {
    private static final String TAG = "RecipeActivity";

    /**
     * ************************************* Declarations ******************************************
     */

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (savedInstanceState != null) {
            //TODO: Restore Data
        }

        //TODO: Setup Logic That happens once in the life of the activity
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
}