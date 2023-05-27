package com.example.atm_3.Retrofit;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {
    private static final String BASE_OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/";

    private static WeatherRepository weatherRepository;

    private OpenWeatherApi openWeatherApi;

    private WeatherRepository(OpenWeatherApi openWeatherApi){ this.openWeatherApi = openWeatherApi;}

    public static WeatherRepository getInstance(){

        if (weatherRepository == null){
            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_OPEN_WEATHER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            weatherRepository= new WeatherRepository(retrofit.create(OpenWeatherApi.class));

        }

        return weatherRepository;
    }

    public void getW(String city, String apiId, final OnGetWeatherCallBack callBack){

        openWeatherApi.getWeather(city, apiId)
                .enqueue(new Callback<WeatherInfo>() {
                    @Override
                    public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                        if (response.isSuccessful()) {
                            WeatherInfo weatherInfo = response.body();  //spune la gson sa imi puna userii din json in lista
                            if (weatherInfo != null) {
                                callBack.onSuccess(weatherInfo);
                            } else {
                                callBack.onError();
                            }
                        } else {
                            callBack.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherInfo> call, Throwable t) {
                        callBack.onError();
                    }
                });

    }




}
