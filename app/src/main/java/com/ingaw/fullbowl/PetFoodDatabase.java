package com.ingaw.fullbowl;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PetFood.class},version = 2)
public abstract class PetFoodDatabase extends RoomDatabase {

    public abstract PetFoodDAO getPetFoodDAO();

    //Singleton
    private static PetFoodDatabase dbInstance;

    public static synchronized PetFoodDatabase getInstance(Context context){
        if(dbInstance == null){
            dbInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PetFoodDatabase.class,
                            "pet_food_db"
                    ).fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }
}
