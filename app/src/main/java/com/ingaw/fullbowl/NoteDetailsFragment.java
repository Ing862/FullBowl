package com.ingaw.fullbowl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.ingaw.fullbowl.databinding.NoteDetailsBinding;

public class NoteDetailsFragment extends Fragment {

    private PetFood petFood;

    public NoteDetailsFragment(PetFood petFood) {
        // Przechowujemy obiekt PetFood przekazany z MainActivity
        this.petFood = petFood;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Wiążemy layout fragmentu z danymi
        NoteDetailsBinding binding = NoteDetailsBinding.inflate(inflater, container, false);

        // Ustawiamy dane do wyświetlenia w widoku
        binding.setPet(petFood);

        return binding.getRoot();
    }
}

