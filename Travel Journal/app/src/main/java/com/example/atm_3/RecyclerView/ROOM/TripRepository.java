package com.example.atm_3.RecyclerView.ROOM;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.PrimaryKey;

import java.util.List;

public class TripRepository {

    private TripDao tripDao;
    private LiveData<List<Trip>> allTrips;

    public TripRepository(Application application){

        TripDataBase tripDataBase = TripDataBase.getInstance(application);
        tripDao = tripDataBase.tripDao();
        allTrips = tripDao.getAllTrips();


    }


    public void insert(Trip trip) {
        TripDataBase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }

    public void update(Trip trip){
        TripDataBase.databaseWriteExecutor.execute(() -> {
            tripDao.update(trip);
        });
    }

    public void delete(Trip trip){
        TripDataBase.databaseWriteExecutor.execute(() -> {
            tripDao.delete(trip);
        });
    }

    public void deleteAllTrips(){
        TripDataBase.databaseWriteExecutor.execute(() -> {
            tripDao.deleteAllTrips();
        });
    }

    public LiveData<List<Trip>> getAllTrips(){
        return allTrips;
    }


}
