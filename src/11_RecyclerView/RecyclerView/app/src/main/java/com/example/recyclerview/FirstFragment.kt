package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val mRecipes = ArrayList<Recipe>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initiate list data
        mRecipes.addAll(RecipeGenerator.generateRecipes())

        //create an adapter
        val recipeListAdapter = RecipeListAdapter()

        //set adapter's data
        recipeListAdapter.setLinked(mRecipes)

        //set wordAdapter into recyclerview's adapter
        recyclerView.adapter = recipeListAdapter

        //set recyclerview's layout manager
        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }
}