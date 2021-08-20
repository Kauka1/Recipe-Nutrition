package com.example.recipe_nutrition.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_nutrition.databinding.RecipesRowLayoutBinding
import com.example.recipe_nutrition.models.FoodRecipe
import com.example.recipe_nutrition.models.Result
import com.example.recipe_nutrition.util.RecipesDiffUtil

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipes = emptyList<Result>()

    //RecipesRowLayoutBinding is the name made automatically from recipes_row_layout xml style
    class MyViewHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //binding the result in the parameter with the result from the xml
        fun bind(result: Result){
            binding.result = result
            binding.executePendingBindings()
        }

        //allows access to above function from elsewhere
        companion object{
            fun from(parent: ViewGroup): MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    //creates the myViewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    //stores current item from recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecipe = recipes[position]

        //makes recylerview update each time we get data from api
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    //sets data of recipes, will be called from find recipe fragment
    fun setData(newData: FoodRecipe){
        val recipesDiffUtil =
            RecipesDiffUtil(recipes, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipes = newData.results

        //updates views with new data
        diffUtilResult.dispatchUpdatesTo(this)
    }

}