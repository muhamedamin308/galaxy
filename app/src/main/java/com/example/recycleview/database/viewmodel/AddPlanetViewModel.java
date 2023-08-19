package com.example.recycleview.database.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.recycleview.database.classes.Planet;
import com.example.recycleview.database.db.PlanetRepository;

public class AddPlanetViewModel extends AndroidViewModel {
    private final PlanetRepository mPlanetRepository;

    public AddPlanetViewModel(@NonNull Application application) {
        super(application);
        mPlanetRepository = new PlanetRepository(application);

    }

    public void insertAV(Planet planet) {
        mPlanetRepository.insertR(planet);
    }

    public void updateAV(Planet planet) {
        mPlanetRepository.updateR(planet);
    }

}
