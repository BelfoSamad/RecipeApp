package com.belfoapps.recipeapp.views.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.belfoapps.recipeapp.R;

public class ChefActivity extends AppCompatActivity {
    private static final String TAG = "ChefActivity";

    /**
     * ************************************* Declarations ******************************************
     */

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        if (savedInstanceState != null) {
            //TODO: Restore Data
        }

        //TODO: Setup Logic That happens once in the life of the activity
    }

    @Override
    protected void onStart() {
        super.onStart();

        //TODO: Init the Code that maintains the UI
    }

    @Override
    protected void onResume() {
        super.onResume();

        //TODO: Run Services that happens when the ui is visible
    }

    @Override
    protected void onPause() {
        super.onPause();

        //TODO: Adjust operations when the ui is invisible (Sound, Camera...etc)
    }

    @Override
    protected void onStop() {
        super.onStop();

        //TODO: Adjust Resources when the ui is invisible (Release animations, location updates...etc)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //TODO: Release Remaining Resources
        if (isFinishing()) {
            //TODO: User closed the Activity
        } else {
            //TODO: Configuration Change
        }
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