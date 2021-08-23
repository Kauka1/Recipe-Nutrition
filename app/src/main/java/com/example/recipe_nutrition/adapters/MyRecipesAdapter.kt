package com.example.recipe_nutrition.adapters

import android.view.*
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_nutrition.R
import com.example.recipe_nutrition.data.database.entities.FavoritesEntity
import com.example.recipe_nutrition.databinding.FavoriteRecipesRowLayoutBinding
import com.example.recipe_nutrition.util.RecipesDiffUtil
import com.example.recipe_nutrition.view.fragments.myRecipes.MyRecipesFragmentDirections
import kotlinx.android.synthetic.main.favorite_recipes_row_layout.view.*

class MyRecipesAdapter(
    private val requireActivity: FragmentActivity
): RecyclerView.Adapter<MyRecipesAdapter.MyViewHolder>(), ActionMode.Callback {

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

        //single click listener
        holder.itemView.favoriteRecipesRowLayout.setOnClickListener {
            val action =
                MyRecipesFragmentDirections.actionMyRecipesFragmentToDetailsActivity(selectedRecipe.result)

            holder.itemView.findNavController().navigate(action)
        }

        //Long click listener
        holder.itemView.favoriteRecipesRowLayout.setOnLongClickListener {
            requireActivity.startActionMode(this)
            true
        }

    }

    fun setData(newFavoriteRecipes: List<FavoritesEntity>){
        val favoriteRecipesDiffUtil =
            RecipesDiffUtil(favoritesRecipes, newFavoriteRecipes)
        val diffUtilResult = DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoritesRecipes = newFavoriteRecipes
        diffUtilResult.dispatchUpdatesTo(this)
    }

    override fun onCreateActionMode(actionMode: ActionMode?, menu: Menu?): Boolean {
        actionMode?.menuInflater?.inflate(R.menu.favorites_contextual_menu, menu)
        return true
    }

    override fun onPrepareActionMode(actionMode: ActionMode?, menu: Menu?): Boolean {
        return true
    }

    override fun onActionItemClicked(actionMode: ActionMode?, menu: MenuItem?): Boolean {
        return true
    }

    override fun onDestroyActionMode(actionMode: ActionMode?) {

    }
}