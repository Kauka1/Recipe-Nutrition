package com.example.recipe_nutrition.models


import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("unit")
    val unit: String
)