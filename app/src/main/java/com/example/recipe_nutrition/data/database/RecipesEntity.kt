package com.example.recipe_nutrition.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipe_nutrition.models.FoodRecipe
import com.example.recipe_nutrition.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}