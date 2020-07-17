package com.belfoapps.recipeapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.viewmodels.ShoppingListViewModel;

public class ShoppingListFragment extends Fragment {
    private static final String TAG = "ShoppingListFragment";

    /**
     * ************************************* Declarations ******************************************
     */
    private ShoppingListViewModel mViewModel;

    /**
     * ************************************** Constructor ******************************************
     */
    public static ShoppingListFragment newInstance() {
        return new ShoppingListFragment();
    }

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Setup Logic That happens once in the life of the fragment
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //TODO: Init UI

        return inflater.inflate(R.layout.shopping_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
        mViewModel = ViewModelProviders.of(this).get(ShoppingListViewModel.class);

        //TODO: Retrieve Views and restoring state
    }

    @Override
    public void onPause() {
        super.onPause();

        //TODO: Adjust operations when the ui is invisible (Sound, Camera...etc)
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

}