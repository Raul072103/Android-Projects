package com.example.atm_3.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherApi {

    @GET("weather")
    Call<WeatherInfo> getWeather(@Query("q") String City, @Query("appid") String apiId);


}
