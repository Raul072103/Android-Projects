package com.example.atm_3.Retrofit;

import com.google.gson.annotations.SerializedName;

public class WeatherInfo {

    @SerializedName("weather")
    public Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
