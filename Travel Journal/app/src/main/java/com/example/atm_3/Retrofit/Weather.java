package com.example.atm_3.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Weather {

    private long id;

    private String main;

    private String description;

    @SerializedName("icon")
    private String iconId;

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIconId() {
        return iconId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }


    @Override
    public String toString() {
        return "Weather: {" +
                "id: " + id +
                ", main: " + main +
                ", description: " + description +
                ", icon: " + iconId +
                "}";
    }

}
