package com.henry.cookrecipes.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.volley.VolleyError;
import com.google.android.material.appbar.MaterialToolbar;
import com.henry.cookrecipes.R;
import com.henry.cookrecipes.adapter.MealAdapter;
import com.henry.cookrecipes.model.Meal;
import com.henry.cookrecipes.networking.APIMeal;
import com.henry.cookrecipes.util.DatabaseFavorite;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements MealAdapter.OnSelected {
    private MaterialToolbar mb;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        mb = findViewById(R.id.mb);
        rv = findViewById(R.id.rv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setSupportActionBar(mb);
        setRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }

    private void setRecyclerView() {
        DatabaseFavorite databaseFavorite = new DatabaseFavorite(this);
        ArrayList<Meal> meals = databaseFavorite.getAll();

        if (meals != null) {
            MealAdapter mealAdapter = new MealAdapter(this);
            mealAdapter.setMeals(meals);
            mealAdapter.setOnSelected(this);
            rv.setAdapter(mealAdapter);
        }
    }

    @Override
    public void onItemSelected(Meal meal) {
        if (meal != null) {
            String id = meal.getId();

            APIMeal apiMeal = new APIMeal(this);
            apiMeal.getMeal(id);
            apiMeal.setOnMealResponse(new APIMeal.OnMealResponse() {
                @Override
                public void onMeal(@Nullable Meal meal, @Nullable VolleyError error) {
                    Intent intent = new Intent(FavoriteActivity.this, MealDetailActivity.class);
                    intent.putExtra(MealDetailActivity.EXTRA_MEAL, meal);
                    startActivity(intent);
                }
            });
        }
    }
}