package com.example.atm_3.RecyclerView.ROOM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository tripRepository;

    private LiveData<List<Trip>> allTrips;


    public TripViewModel(@NonNull Application application) {
        super(application);
        tripRepository = new TripRepository(application);
        allTrips = tripRepository.getAllTrips();

    }

    public void insert(Trip trip){
        tripRepository.insert(trip);
    }

    public void update(Trip trip){
        tripRepository.update((trip));
    }
    public void delete(Trip trip){
        tripRepository.delete(trip);
    }

    public void deleteAllTrips(){
        tripRepository.deleteAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips(){
        return allTrips;
    }

}
