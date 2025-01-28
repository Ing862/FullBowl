package com.ingaw.fullbowl;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ingaw.fullbowl.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //data source
    private PetFoodDatabase petFoodDatabase;
    private ArrayList<PetFood> foods = new ArrayList<>();

    //adapter
    private FoodAdapter foodAdapter;

    //binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

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
        FoodViewModel viewModel = new ViewModelProvider(this)
                .get(FoodViewModel.class);

        //add new food for testing
//        PetFood food1 = new PetFood();
//        viewModel.addNewPetFood(food1);

        //loading data
        viewModel.getAllPetFoods().observe(this,
                new Observer<List<PetFood>>() {
                    @Override
                    public void onChanged(List<PetFood> petFoods) {

                        foods.clear();
                        foods.addAll(petFoods);
                        foodAdapter.setPetFoods(foods);

                        for (PetFood c: petFoods){
                            Log.v("TAGY", c.getName());
                        }
                    }
                });

        foodAdapter = new FoodAdapter(foods);

        //linking recycler view
        recyclerView.setAdapter(foodAdapter);

        //swipe to delete :)
        // swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // If you swipe the item to the left
                PetFood c = foods.get(viewHolder.getAdapterPosition());

                viewModel.deletePetFood(c);

                Toast.makeText(getApplicationContext(), "Śpieszmy się kochać słote myśli, tak szybko odchodzą", Toast.LENGTH_LONG).show();
            }
        }).attachToRecyclerView(recyclerView);

    }






}