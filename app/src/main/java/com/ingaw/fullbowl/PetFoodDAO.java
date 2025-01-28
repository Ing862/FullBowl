package com.ingaw.fullbowl;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PetFoodDAO {
    @Insert
    void insert(PetFood petFood);

    @Delete
    void delete(PetFood petFood);

    @Query("SELECT * FROM pet_food_table")
    LiveData<List<PetFood>> getAllPetFood();

}
