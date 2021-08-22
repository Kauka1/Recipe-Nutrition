package com.example.recipe_nutrition.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_nutrition.data.database.entities.FavoritesEntity
import com.example.recipe_nutrition.databinding.FavoriteRecipesRowLayoutBinding
import com.example.recipe_nutrition.util.RecipesDiffUtil

class MyRecipesAdapter: RecyclerView.Adapter<MyRecipesAdapter.MyViewHolder>() {

    private var favoritesRecipes = emptyList<FavoritesEntity>()

    class MyViewHolder(private val binding: FavoriteRecipesRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(favoritesEntity: FavoritesEntity){
            binding.favoritesEntity = favoritesEntity
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FavoriteRecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun getItemCount(): Int {
        return favoritesRecipes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedRecipe = favoritesRecipes[position]
        holder.bind(selectedRecipe)
    }

    fun setData(newFavoriteRecipes: List<FavoritesEntity>){
        val favoriteRecipesDiffUtil =
            RecipesDiffUtil(favoritesRecipes, newFavoriteRecipes)
        val diffUtilResult = DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoritesRecipes = newFavoriteRecipes
        diffUtilResult.dispatchUpdatesTo(this)
    }
}