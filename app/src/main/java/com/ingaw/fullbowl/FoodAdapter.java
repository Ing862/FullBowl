package com.ingaw.fullbowl;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ingaw.fullbowl.databinding.FoodListItemBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<PetFood> petFoods;

    public FoodAdapter(ArrayList<PetFood> petFoods) {
        this.petFoods = petFoods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodListItemBinding foodListItemBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.food_list_item,
                        parent,
                        false
                );
        return new FoodViewHolder(foodListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        PetFood currentFood = petFoods.get(position);

        holder.foodListItemBinding.setPetFood(currentFood);
    }

    @Override
    public int getItemCount() {
        if(petFoods != null){
            return petFoods.size();
        }else {
            return 0;
        }
    }

    public void setPetFoods(ArrayList<PetFood> petFoods) {
        this.petFoods = petFoods;

        notifyDataSetChanged();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        private FoodListItemBinding foodListItemBinding;

        public FoodViewHolder(@NonNull FoodListItemBinding foodListItemBinding){
            super(foodListItemBinding.getRoot());
            this.foodListItemBinding = foodListItemBinding;
        }
    }
}
