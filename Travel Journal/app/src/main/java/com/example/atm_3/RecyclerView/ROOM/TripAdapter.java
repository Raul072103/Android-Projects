package com.example.atm_3.RecyclerView.ROOM;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.atm_3.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripHoler> {


    private List<Trip> trips = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public TripHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new TripHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripHoler holder, int position) {
        Trip currentTrip = trips.get(position);
        holder.textViewTripName.setText(currentTrip.getTripName());
        holder.textViewDestination.setText(currentTrip.getDestination());
        holder.ratingBarStars.setNumStars(currentTrip.getNrOfStars());
        holder.checkBoxFavourite.setChecked(currentTrip.isFavourite());

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

    public Trip getTripAt(int position) {
        return trips.get(position);
    }

    class TripHoler extends RecyclerView.ViewHolder {

        private TextView textViewTripName, textViewDestination;
        private RatingBar ratingBarStars;
        private CheckBox checkBoxFavourite;


        public TripHoler(@NonNull View itemView) {
            super(itemView);
            textViewTripName = itemView.findViewById(R.id.TripName);
            textViewDestination = itemView.findViewById(R.id.Destination);
            ratingBarStars = itemView.findViewById(R.id.ratingBar);
            checkBoxFavourite = itemView.findViewById(R.id.FavouritecheckBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(trips.get(position));
                    }
                }

            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemLongClick(trips.get(position));
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    public interface OnItemClickListener {

        void onItemClick(Trip trip);
        void onItemLongClick(Trip trip);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
