package com.example.recipe_nutrition.view.fragments.findRecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipe_nutrition.R
import kotlinx.android.synthetic.main.fragment_find_recipes.view.*

class FindRecipesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_find_recipes, container, false)

        view.recyclerView.showShimmer()

        return view
    }

}