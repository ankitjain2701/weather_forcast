package com.demo.weather_forcast.Api;

import com.demo.weather_forcast.model.OneClassRequest;
import com.demo.weather_forcast.model.OneClassResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("data/2.5/onecall")
    Call<OneClassResponse> getWeatherByLocation(@Query("lon") Double lon, @Query("lat") Double lat, @Query("appid") String appid, @Query("exclude") String Exclude);

}
