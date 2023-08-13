package com.example.recycleview.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GalaxyDao {
    @Insert
    void insert(Planet planet);

    @Update
    void update(Planet planet);

    @Delete
    void delete(Planet planet);

    @Query("DELETE FROM Planet")
    void deleteAll();

    @Query("SELECT * FROM Planet")
    LiveData<List<Planet>> getAllPlanets();
}
