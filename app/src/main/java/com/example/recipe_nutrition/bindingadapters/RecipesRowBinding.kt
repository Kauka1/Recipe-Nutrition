package com.example.recipe_nutrition.bindingadapters

import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.example.recipe_nutrition.R
import com.example.recipe_nutrition.models.Result
import com.example.recipe_nutrition.view.fragments.findRecipes.FindRecipesFragmentDirections
import org.jsoup.Jsoup
import java.lang.Exception

//converting the text under the thumbs and time into strings. Also changing the color of vegan
class RecipesRowBinding {

    companion object{

        @BindingAdapter("onRecipeClickListener")
        @JvmStatic
        fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: Result){
            recipeRowLayout.setOnClickListener {
                try {
                    val action =
                        FindRecipesFragmentDirections.actionFindRecipesFragmentToDetailsActivity(result)
                    recipeRowLayout.findNavController().navigate(action)
                } catch (e: Exception){
                    Log.d("onRecipeClickListener", e.toString())
                }
            }
        }

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String){
            imageView.load(imageUrl){
                crossfade(600)
            }
        }

        @BindingAdapter("setNumberOfLikes")
        @JvmStatic
        fun setNumberOfLikes(textView: TextView, likes: Int){
            textView.text = likes.toString()
        }

        @BindingAdapter("setNumberOfMinutes")
        @JvmStatic
        fun setNumberOfMinutes(textView: TextView, minutes: Int){
            textView.text = minutes.toString()
        }

        @BindingAdapter("applyVeganColor")
        @JvmStatic
        fun applyVeganColor(view: View, vegan: Boolean){
            if (vegan){
                when(view){
                    is TextView -> {
                        view.setTextColor(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                    is ImageView -> {
                         view.setColorFilter(
                             ContextCompat.getColor(
                                 view.context,
                                 R.color.green
                             )
                         )
                    }
                }
            }
        }

        //formats the description texts in the app properly
        @BindingAdapter("parseHtml")
        @JvmStatic
        fun parseHtml(textView: TextView, description: String?){
            if (description != null){
                val desc = Jsoup.parse(description).text()
                textView.text = desc
            }
        }

    }
}