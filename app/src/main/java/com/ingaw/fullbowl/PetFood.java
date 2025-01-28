package com.ingaw.fullbowl;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pet_food_table")
public class PetFood {
    @ColumnInfo(name = "pet_food_id")
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "pet_food_name")
    private String name;

    @ColumnInfo(name = "pet_name")
    private String pet_name;

    @ColumnInfo(name = "pet_food_weight")
    private int weight;


    public PetFood( int weight, String name, String pet_name) {

        this.weight = weight;
        this.name = name;
        this.pet_name = pet_name;
    }

    public PetFood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
