package com.ingaw.fullbowl;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pet_food")
public class PetFood {
    @ColumnInfo(name = "pet_food_id")
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "pet_food_name")
    private String Name;

    @ColumnInfo(name = "pet_food_weight")
    private int weight;

    @ColumnInfo(name = "pet_food_brand")
    private String brand;

    


    public PetFood(String brand, int weight, String name, int id) {
        this.brand = brand;
        this.weight = weight;
        Name = name;
        this.id = id;
    }
}
