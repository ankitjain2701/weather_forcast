package com.demo.weather_forcast.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

public static String base_url="https://api.openweathermap.org/";

public static Retrofit getClient(){
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit;
}
public static ApiInterface apiInterface(){
    return getClient().create(ApiInterface.class);
}
}
