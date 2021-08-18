package com.example.recipe_nutrition.models


import com.example.recipe_nutrition.models.Nutrient
import com.google.gson.annotations.SerializedName

data class IngredientX(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("nutrients")
    val nutrients: List<Nutrient>,
    @SerializedName("unit")
    val unit: String
)