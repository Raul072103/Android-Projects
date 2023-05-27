package com.example.atm_3.RecyclerView.ROOM;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trip_table")
public class Trip {


    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name = "tripName")
    private String tripName;

    public Trip(@NonNull String tripName, @NonNull String destination, Integer nrOfStars, @NonNull String startDate, @NonNull String endDate, boolean cityBreak, boolean seaSide, boolean mountains, Integer pictureID, boolean isFavourite) {
        this.tripName = tripName;
        this.destination = destination;
        this.nrOfStars = nrOfStars;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cityBreak = cityBreak;
        this.seaSide = seaSide;
        this.mountains = mountains;
        this.pictureID = pictureID;
        this.isFavourite = isFavourite;
    }

    @NonNull
    @ColumnInfo(name = "destination")
    private String destination;

    @ColumnInfo(name = "nrOfStars")
    private Integer nrOfStars;

    @NonNull
    @ColumnInfo(name = "startDate")
    private String startDate;

    @NonNull
    @ColumnInfo(name = "endDate")
    private String endDate;

    @ColumnInfo(name = "city_break")
    private boolean cityBreak;

    @ColumnInfo(name = "sea_side")
    private boolean seaSide;

    @ColumnInfo(name = "mountains")
    private boolean mountains;

    @ColumnInfo(name = "picture_ID")
    private Integer pictureID;


    public Integer getPictureID() {
        return pictureID;
    }

    public void setPictureID(Integer pictureID) {
        this.pictureID = pictureID;
    }

    @ColumnInfo(name = "is_favourite")
    private boolean isFavourite;

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        this.isFavourite = favourite;
    }

    @NonNull
    public String getTripName() {
        return tripName;
    }

    public void setTripName(@NonNull String tripName) {
        this.tripName = tripName;
    }

    @NonNull
    public String getDestination() {
        return destination;
    }

    public void setDestination(@NonNull String destination) {
        this.destination = destination;
    }

    public Integer getNrOfStars() {
        return nrOfStars;
    }

    public void setNrOfStars(Integer nrOfStars) {
        this.nrOfStars = nrOfStars;
    }

    @NonNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull String startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NonNull String endDate) {
        this.endDate = endDate;
    }

    public boolean isCityBreak() {
        return cityBreak;
    }

    public void setCityBreak(boolean cityBreak) {
        this.cityBreak = cityBreak;
    }

    public boolean isSeaSide() {
        return seaSide;
    }

    public void setSeaSide(boolean seaSide) {
        this.seaSide = seaSide;
    }

    public boolean isMountains() {
        return mountains;
    }

    public void setMountains(boolean mountains) {
        this.mountains = mountains;
    }
}