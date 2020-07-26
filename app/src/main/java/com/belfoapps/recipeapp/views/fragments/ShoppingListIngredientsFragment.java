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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belfoapps.recipeapp.databinding.ShoppingListIngredientsFragmentBinding;
import com.belfoapps.recipeapp.ui.adapters.IngredientsAdapter;
import com.belfoapps.recipeapp.viewmodels.ShoppingListViewModel;

public class ShoppingListIngredientsFragment extends Fragment {
    private static final String TAG = "ShoppingIngredientsFrag";

    /**
     * ************************************* Declarations ******************************************
     */
    private ShoppingListViewModel mViewModel;
    private ShoppingListIngredientsFragmentBinding mBinding;
    private IngredientsAdapter mAdapter;

    /**
     * ************************************** Constructor ******************************************
     */
    public static ShoppingListIngredientsFragment newInstance() {
        ShoppingListIngredientsFragment fragment = new ShoppingListIngredientsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * *********************************** Life Cycle Methods **************************************
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Get recipe id
            String recipe_id = getArguments().getString("recipe_id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = ShoppingListIngredientsFragmentBinding.inflate(inflater, container, false);

        //go back
        mBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        //TODO: Get Ingredients
        String[] ingredients = {"Ingredient 1", "Ingredient 2", "Ingredient 3", "Ingredient 4"};
        initIngredientsRecyclerView(ingredients);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
        mViewModel = ViewModelProviders.of(this).get(ShoppingListViewModel.class);
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
    private void initIngredientsRecyclerView(String[] ingredients) {
        mAdapter = new IngredientsAdapter(ingredients, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mBinding.slIngredientsRecyclerview.setLayoutManager(manager);
        mBinding.slIngredientsRecyclerview.setAdapter(mAdapter);
        mBinding.slIngredientsRecyclerview.addItemDecoration(new MyItemDecoration());
    }

    private static class MyItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
            super.getItemOffsets(outRect, itemPosition, parent);

            outRect.bottom = 8;
        }
    }
}