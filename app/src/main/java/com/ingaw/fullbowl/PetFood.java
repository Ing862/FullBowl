package com.ingaw.fullbowl;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    @ColumnInfo(name = "pet_food_brand")
    private String brand;

    @ColumnInfo(name = "pet_food_photo_path")
    private String imagePath;

    @ColumnInfo(name = "food_daily_portion")
    private int daily_portion;

    @ColumnInfo(name = "food_starting_date")
    private String starting_date;

    public PetFood(String imagePath, String brand, int weight, String name, String pet_name, int daily_portion, String starting_date) {
        this.imagePath = imagePath;
        this.brand = brand;
        this.weight = weight;
        this.name = name;
        this.pet_name = pet_name;
        this.daily_portion = daily_portion;
        this.starting_date = starting_date;

    }



    public int count_days_left(int weight, int daily_portion, String starting_date) {
        // Parse the String to LocalDate using the formatter
        LocalDate localDate = LocalDate.parse(starting_date);

        if (daily_portion <= 0) {
            return 0;
        }
        if (starting_date == null) {
            return -1;
        }
        LocalDate today = LocalDate.now();
        long days_passed = ChronoUnit.DAYS.between(localDate, today);

        int eating_days = weight / daily_portion;
        int days_left = eating_days - (int) days_passed;

        return days_left > 0 ? days_left : 0;
    }

    public PetFood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public int getDaily_portion() {
        return daily_portion;
    }

    public void setDaily_portion(int daily_portion) {
        this.daily_portion = daily_portion;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }
}
