package com.example.traveljournal.home_recyclerView;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;

public class TripModelViewHolder extends RecyclerView.ViewHolder{

    private TextView tripName, destination;
    private ImageView picture;
    private RatingBar ratingBar;
    private CheckBox checkBoxFavourite;

    private ConstraintLayout constraintLayout;

    public TripModelViewHolder(@NonNull  View itemView){
        super(itemView);
        tripName = itemView.findViewById(R.id.TripName);
        destination = itemView.findViewById(R.id.Destination);
        ratingBar = itemView.findViewById(R.id.ratingBar);
        picture = itemView.findViewById(R.id.PictureTrip);
        checkBoxFavourite = itemView.findViewById(R.id.FavouritecheckBox);
        constraintLayout = itemView.findViewById(R.id.constrainLayoutInsideCardView);
    }


    public TextView getTripName() {
        return tripName;
    }

    public TextView getDestination() {
        return destination;
    }

    public ImageView getPicture() {
        return picture;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public CheckBox getCheckBoxFavourite() {
        return checkBoxFavourite;
    }
}
