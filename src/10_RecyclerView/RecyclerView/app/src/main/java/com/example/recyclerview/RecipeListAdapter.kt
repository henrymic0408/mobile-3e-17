package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.wordlist_item.view.*
import kotlin.collections.ArrayList

class RecipeListAdapter : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {

    //adapter's data
    private val mFoodList = ArrayList<Recipe>()

    //set adapter's data
    fun setLinked(list: ArrayList<Recipe>) {
        this.mFoodList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wordlist_item, parent, false)
        return ViewHolder(view) //inflating layout item
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.ViewHolder, position: Int) {
        holder.bind(mFoodList[position]) //binding each item
    }

    override fun getItemCount(): Int = mFoodList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recipe: Recipe) {
            with(itemView) {

                //set recipe
                tv_recipe_title_list.text = recipe.title
                tv_recipe_description_list.text = recipe.description

                //item on click listener
                itemView.setOnClickListener {
                    val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(recipe)
                    itemView.findNavController().navigate(action)
                }
            }
        }
    }
}