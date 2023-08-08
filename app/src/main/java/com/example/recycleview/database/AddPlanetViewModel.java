package com.example.recycleview.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddPlanetViewModel extends AndroidViewModel {
    private final PlanetRepository mPlanetRepository;

    public AddPlanetViewModel(@NonNull Application application) {
        super(application);
        mPlanetRepository = new PlanetRepository(application);

    }

    public void insertAV (Planet planet){
        mPlanetRepository.insertR(planet);
    }
    public void updateAV (Planet planet){
        mPlanetRepository.updateR(planet);
    }

}
