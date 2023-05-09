package com.example.traveljournal.home_recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;

import java.util.List;

public class TripAdapter  extends RecyclerView.Adapter<TripModelViewHolder> {

    private List<TripModel> tripModels;

    public TripAdapter(List<TripModel> tripModelsList) {
       tripModels = tripModelsList;
    }


    @NonNull
    @Override
    public TripModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where we inflate
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_views, parent, false);
        return new TripModelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripModelViewHolder holder, int position) {
        //assigning values to the viw we created in the recycler_view_row layout file
        // based on the position of the recycler view
        TripModel currentTrip = tripModels.get(position);
        holder.getTripName().setText(currentTrip.getTripName());
        holder.getDestination().setText(currentTrip.getDestination());
        holder.getPicture().setImageResource(currentTrip.getPictureID());
        holder.getRatingBar().setRating(currentTrip.getRating());
        holder.getCheckBoxFavourite().setChecked(currentTrip.getChecked());
    }

    @Override
    public int getItemCount() {
        return tripModels.size();
    }
}
