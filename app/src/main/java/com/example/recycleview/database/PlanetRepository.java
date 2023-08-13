package com.example.recycleview.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanetRepository {
    private final GalaxyDao mgalaxyDao;
    private final LiveData<List<Planet>> getAllSpace;

    public PlanetRepository(Application application) {
        GalaxyRoomDB db = GalaxyRoomDB.getInstance(application);
        mgalaxyDao = db.galaxyDao();
        getAllSpace = mgalaxyDao.getAllPlanets();
    }

    //Operations


    //Insert
    public void insertR(Planet planet) {
        new InsertAsyncTask(mgalaxyDao).execute(planet);
    }

    //Update
    public void updateR(Planet planet) {
        new UpdateAsyncTask(mgalaxyDao).execute(planet);
    }

    //Delete
    public void deleteR(Planet planet) {
        new DeleteAsyncTask(mgalaxyDao).execute(planet);
    }

    //Delete All
    public void deleteAllPlanets() {
        new DeleteAllAsyncTask(mgalaxyDao).execute();
    }

    //Get All Data
    public LiveData<List<Planet>> getAllData() {
        return getAllSpace;
    }


    private static class InsertAsyncTask extends AsyncTask<Planet, Void, Void> {
        private final GalaxyDao mGalaxyDao;

        public InsertAsyncTask(GalaxyDao galaxyDao) {
            mGalaxyDao = galaxyDao;
        }

        @Override
        protected Void doInBackground(Planet... planets) {
            mGalaxyDao.insert(planets[0]);

            return null;
        }
    }


    private static class UpdateAsyncTask extends AsyncTask<Planet, Void, Void> {
        private final GalaxyDao mGalaxyDao;

        public UpdateAsyncTask(GalaxyDao galaxyDao) {
            mGalaxyDao = galaxyDao;
        }

        @Override
        protected Void doInBackground(Planet... planets) {
            mGalaxyDao.update(planets[0]);
            return null;
        }
    }


    private static class DeleteAsyncTask extends AsyncTask<Planet, Void, Void> {
        private final GalaxyDao mGalaxyDao;

        public DeleteAsyncTask(GalaxyDao galaxyDao) {
            mGalaxyDao = galaxyDao;
        }

        @Override
        protected Void doInBackground(Planet... planets) {
            mGalaxyDao.delete(planets[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private final GalaxyDao mGalaxyDao;

        public DeleteAllAsyncTask(GalaxyDao galaxyDao) {
            mGalaxyDao = galaxyDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mGalaxyDao.deleteAll();
            return null;
        }
    }

}
