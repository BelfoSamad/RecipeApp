package com.belfoapps.recipeapp.views.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.belfoapps.recipeapp.databinding.ActivityMainBinding;
import com.belfoapps.recipeapp.views.fragments.ShoppingListIngredientsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int CONTENT_VIEW_ID = 10101010;

    /**
     * ************************************* Declarations ******************************************
     */
    ActivityMainBinding mBinding;

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

        //TODO: Remove This
        /*
        FrameLayout frame = new FrameLayout(this);
        frame.setId(CONTENT_VIEW_ID);
        setContentView(frame, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(CONTENT_VIEW_ID, ShoppingListIngredientsFragment.newInstance()).commit();
        }*/

        setDrawerMenuCallbacks();
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

        mBinding.openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.drawerMenu.openDrawer(GravityCompat.START);
            }
        });
    }
}