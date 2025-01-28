package com.ingaw.fullbowl;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final PetFoodDAO petFoodDAO;
    ExecutorService executor;
    Handler handler;


    public Repository(Application application) {

        PetFoodDatabase petFoodDatabase = PetFoodDatabase.getInstance(application);
        this.petFoodDAO = petFoodDatabase.getPetFoodDAO();

        // Used for Background Database Operations
        executor = Executors.newSingleThreadExecutor();

        // Used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    public void addPetFood(PetFood food){
        // backgroud database operaton
        executor = Executors.newSingleThreadExecutor();
        // updating ui
        handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                petFoodDAO.insert(food);
            }
        });
    }


    public void deletePetFood(PetFood pet){
        // backgroud database operaton
        executor = Executors.newSingleThreadExecutor();
        // updating ui
        handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                petFoodDAO.delete(pet);
            }
        });
    }

    public LiveData<List<PetFood>> getAllPetFoods(){
        return petFoodDAO.getAllPetFoods();
    }
}
