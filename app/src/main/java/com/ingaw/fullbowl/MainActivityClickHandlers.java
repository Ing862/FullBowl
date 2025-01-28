package com.ingaw.fullbowl;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandlers {

    Context context;

    public MainActivityClickHandlers(Context context){
        this.context = context;
    }

    public void onFABClicked(View view){
        Intent i = new Intent(view.getContext(), AddNewPetFoodActivity.class);
        context.startActivity(i);
    }


}
