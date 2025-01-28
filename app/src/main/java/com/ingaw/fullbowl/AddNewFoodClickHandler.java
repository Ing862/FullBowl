package com.ingaw.fullbowl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewFoodClickHandler {

    PetFood petFood;
    Context context;
    FoodViewModel foodViewModel;

    public AddNewFoodClickHandler(Context context, PetFood petFood, FoodViewModel foodViewModel) {
        this.context = context;
        this.petFood = petFood;
        this.foodViewModel = foodViewModel;
    }

    public void onSubmitBtnClicked(View view){
        if ((petFood.getName() == null) || (petFood.getPet_name() == null) || petFood.getDate_pet() == null) {
            Toast.makeText(context, "Fields Cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context,MainActivity.class);

            PetFood c = new PetFood(
                    petFood.getName(),
                    petFood.getPet_name(),
                    petFood.getDate_pet()

            );

            foodViewModel.addNewPetFood(c);

            context.startActivity(i);

        }
    }
}
