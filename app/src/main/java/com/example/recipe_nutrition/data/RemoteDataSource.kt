package com.example.recipe_nutrition.data

import com.example.recipe_nutrition.data.network.FoodRecipesApi
import com.example.recipe_nutrition.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

//the inject annotation will automatically provide the foodapi from the network object
//This remote data source class is specifically for searching from the spoonacular API
class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    //This will return the recipes wrapped in a response
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.searchRecipes(searchQuery)
    }

}