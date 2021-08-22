package com.example.recipe_nutrition.data.database

import androidx.room.TypeConverter
import com.example.recipe_nutrition.models.FoodRecipe
import com.example.recipe_nutrition.models.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//converts recipes/favorites into string and vice versa for the RecipesEntity to store in database
class RecipesTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun resultToString(result: Result): String{
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data: String): Result {
        val listType = object : TypeToken<Result>(){}.type
        return gson.fromJson(data, listType)
    }

}