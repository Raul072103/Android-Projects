package com.example.atm_3.RecyclerView.ROOM;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TripDao {

    @Insert
    void insert(Trip trip);

    @Update
    void update(Trip trip);

    @Delete
    void delete(Trip trip);

    @Query("DELETE FROM trip_table")
    void deleteAllTrips();

    @Query("SELECT * FROM trip_table ORDER BY is_favourite DESC")
    LiveData<List<Trip>> getAllTrips();




}
