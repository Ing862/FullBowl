package com.ingaw.fullbowl;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    // repository
    private Repository myRepository;

    // LiveData
    private LiveData<List<PetFood>> allPetFoods;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<PetFood>> getAllPetFoods(){
        allPetFoods = myRepository.getAllPetFoods();
        return allPetFoods;
    }

    public void addNewPetFood(PetFood food){
        myRepository.addPetFood(food);
    }

    public void deletePetFood(PetFood food){
        myRepository.deletePetFood(food);
    }
}
