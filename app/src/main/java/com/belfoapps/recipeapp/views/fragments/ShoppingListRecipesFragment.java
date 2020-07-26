package com.belfoapps.recipeapp.views.fragments;

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

import com.belfoapps.recipeapp.R;
import com.belfoapps.recipeapp.databinding.ShoppingListRecipesFragmentBinding;
import com.belfoapps.recipeapp.models.Recipe;
import com.belfoapps.recipeapp.ui.adapters.RecipesAdapter;
import com.belfoapps.recipeapp.viewmodels.ShoppingListViewModel;
import com.belfoapps.recipeapp.views.MainListener;

import java.util.ArrayList;

public class ShoppingListRecipesFragment extends Fragment {
    private static final String TAG = "ShoppingRecipeFrag";

    /**
     * ************************************* Declarations ******************************************
     */
    private ShoppingListViewModel mViewModel;
    private ShoppingListRecipesFragmentBinding mBinding;
    private RecipesAdapter mAdapter;
    private MainListener listener;

    /**
     * ************************************** Constructor ******************************************
     */
    public static ShoppingListRecipesFragment newInstance() {
        ShoppingListRecipesFragment fragment = new ShoppingListRecipesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
            throw new ClassCastException(context.toString() + " must implement SLRecipesFragmentEvents");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = ShoppingListRecipesFragmentBinding.inflate(inflater, container, false);

        //go back
        mBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        //TODO: Get Shopping List Recipes
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Recipe 1", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 2", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 3", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 4", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 5", R.drawable.recipe));
        recipes.add(new Recipe("Recipe 6", R.drawable.recipe));
        initSLRecipesRecyclerView(recipes);

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
    private void initSLRecipesRecyclerView(ArrayList<Recipe> recipes) {
        mAdapter = new RecipesAdapter(recipes, getContext(), "SL");
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mBinding.slRecipesRecyclerview.setLayoutManager(manager);
        mBinding.slRecipesRecyclerview.setAdapter(mAdapter);
        mBinding.slRecipesRecyclerview.addItemDecoration(new MyItemDecoration());
    }

    private static class MyItemDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = 32;
            outRect.right = 32;
            outRect.bottom = 24;
        }
    }
}