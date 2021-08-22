package com.example.recipe_nutrition.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipe_nutrition.models.Result
import com.example.recipe_nutrition.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)