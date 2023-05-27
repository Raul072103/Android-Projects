package com.example.atm_3.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atm_3.NavigationActivity;
import com.example.atm_3.NewTripActivity;
import com.example.atm_3.RecyclerView.ROOM.Trip;
import com.example.atm_3.RecyclerView.ROOM.TripAdapter;
import com.example.atm_3.RecyclerView.ROOM.TripViewModel;
import com.example.atm_3.databinding.FragmentHomeBinding;

import java.util.List;
import com.example.atm_3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TripViewModel tripViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
/*
        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        TripAdapter tripAdapter = new TripAdapter();
        recyclerView.setAdapter(tripAdapter);

        /*Bundle args = getArguments();
        if(args != null){
            String tripName = args.getString(NewTripActivity.EXTRA_TRIP_NAME);
            String destination = args.getString(NewTripActivity.EXTRA_DESTINATION);
            int nrOfStars = args.getInt(NewTripActivity.EXTRA_NR_OF_STARS, 1);
            boolean isChecked = args.getBoolean(NewTripActivity.EXTRA_IS_CHECKED, false);
            Log.e("Main", tripName);

            Trip trip = new Trip(tripName, destination, nrOfStars, "23", "24", true,false,false,R.drawable.logo,isChecked );
            tripViewModel.insert(trip);
        }


        tripViewModel = new ViewModelProvider(getActivity()).get(TripViewModel.class);
        tripViewModel.getAllTrips().observe(getViewLifecycleOwner(), new Observer<List<Trip>>() {
            @Override
            public void onChanged(List<Trip> trips) {
                tripAdapter.setTrips(trips);

            }
        });


*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}