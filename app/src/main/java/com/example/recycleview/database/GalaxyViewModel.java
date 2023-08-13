package com.example.recycleview.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GalaxyViewModel extends AndroidViewModel {
    private final PlanetRepository mPlanetRepository;
    private final LiveData<List<Planet>> mAllData;

    public GalaxyViewModel(@NonNull Application application) {
        super(application);
        mPlanetRepository = new PlanetRepository(application);
        mAllData = mPlanetRepository.getAllData();
    }

    public void insertV(Planet planet) {
        mPlanetRepository.insertR(planet);
    }

    public void updateV(Planet planet) {
        mPlanetRepository.updateR(planet);
    }

    public void deleteV(Planet planet) {
        mPlanetRepository.deleteR(planet);
    }

    public void deleteAllPlanets() {
        mPlanetRepository.deleteAllPlanets();
    }

    public LiveData<List<Planet>> getmAllData() {
        return mAllData;
    }
}
