package com.ingaw.fullbowl;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pet_food_table")
public class PetFood {
    @ColumnInfo(name = "pet_food_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "pet_food_name")
    private String name;

    @ColumnInfo(name = "pet_name")
    private String pet_name;

    @ColumnInfo(name = "date")
    private String date_pet;


    public PetFood( String name, String pet_name, String date) {

        this.name = name;
        this.pet_name = pet_name;
        this.date_pet = date;
    }

    public String getDate_pet() {
        return date_pet;
    }

    public void setDate_pet(String date_pet) {
        this.date_pet = date_pet;
    }

    public PetFood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }


}
