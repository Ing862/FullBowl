package com.ingaw.fullbowl;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ingaw.fullbowl.databinding.ActivityMainBinding;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //data source
    private PetFoodDatabase petFoodDatabase;
    private ArrayList<PetFood> foodsArrayList = new ArrayList<>();

    //adapter
    private FoodAdapter foodAdapter;

    //binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers handlers;

    //view model
    FoodViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);

        mainBinding.setClickHandler(handlers);

        //recyclerView
        RecyclerView recyclerView = mainBinding.headerRecyclerViewPets;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        //database
        petFoodDatabase = PetFoodDatabase.getInstance(this);

        //view model
        viewModel = new ViewModelProvider(this)
                .get(FoodViewModel.class);

        //add new food for testing
        PetFood food1 = new PetFood( "", "brand", 200, "banana", "Melcia", 20, "2025-01-25");
        viewModel.addNewPetFood(food1);
        viewModel.addNewPetFood(food1);




        //loading data
        viewModel.getAllPetFoods().observe(this,
                new Observer<List<PetFood>>() {
                    @Override
                    public void onChanged(List<PetFood> petFoods) {
                        foodsArrayList.clear();

                        for (PetFood c: petFoods){
                            Log.v("TAGY", c.getName());
                            foodsArrayList.add(c);
                        }

                        foodAdapter.notifyDataSetChanged();
                    }
                });

        //adapter
        foodAdapter = new FoodAdapter(foodsArrayList);

        //linking recycler view
        recyclerView.setAdapter(foodAdapter);


    }
}