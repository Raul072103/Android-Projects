package com.example.traveljournal.home_recyclerView;



public class TripModel {

    private String tripName;
    private String destination;
    private Integer pictureID;
    private Integer rating;
    private Boolean isChecked;


    public TripModel(String tripName, String destination, Integer pictureID, Integer rating, Boolean isChecked) {
        this.tripName = tripName;
        this.destination = destination;
        this.pictureID = pictureID;
        this.rating = rating;
        this.isChecked = isChecked;
    }


    public String getTripName() {
        return tripName;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getPictureID() {
        return pictureID;
    }

    public Integer getRating() {
        return rating;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPictureUrl(Integer pictureID) {
        this.pictureID = pictureID;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
