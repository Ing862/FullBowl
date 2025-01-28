package com.ingaw.fullbowl;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ingaw.fullbowl.databinding.ActivityAddNewPetFoodBinding;

public class AddNewPetFoodActivity extends AppCompatActivity {

    private ActivityAddNewPetFoodBinding binding;
    private AddNewFoodClickHandler handler;
    private PetFood petFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_new_pet_food);

        petFood = new PetFood();

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_pet_food
        );

        FoodViewModel food = new ViewModelProvider(this)
                .get(FoodViewModel.class);

        handler = new AddNewFoodClickHandler(
                this,
                petFood,
                food
        );

        binding.setPetFood(petFood);
        binding.setClickHandler(handler);

    }
}