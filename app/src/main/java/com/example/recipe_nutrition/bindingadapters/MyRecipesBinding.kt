package com.example.recipe_nutrition.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_nutrition.adapters.MyRecipesAdapter
import com.example.recipe_nutrition.data.database.entities.FavoritesEntity

class MyRecipesBinding {

    companion object {

        @BindingAdapter("viewVisiblity", "setData", requireAll = false)
        @JvmStatic
        fun setDataAndViewVisibility(view: View, favoritesEntity: List<FavoritesEntity>?, mAdapter: MyRecipesAdapter?){
            if(favoritesEntity.isNullOrEmpty()){
                when(view){
                    is ImageView -> {
                        view.visibility = View.VISIBLE
                    }
                    is TextView -> {
                        view.visibility = View.VISIBLE
                    }
                    is RecyclerView -> {
                        view.visibility = View.INVISIBLE
                    }
                }
            } else {
                when(view){
                    is ImageView -> {
                        view.visibility = View.INVISIBLE
                    }
                    is TextView -> {
                        view.visibility = View.INVISIBLE
                    }
                    is RecyclerView -> {
                        view.visibility = View.VISIBLE
                        mAdapter?.setData(favoritesEntity)
                    }
                }
            }
        }
    }

}