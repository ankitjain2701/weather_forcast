package com.demo.weather_forcast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.weather_forcast.Api.ApiClient;
import com.demo.weather_forcast.model.CurrentLocation;
import com.demo.weather_forcast.model.OneClassRequest;
import com.demo.weather_forcast.model.OneClassResponse;

public class MainActivity extends AppCompatActivity {
    TextView tv_print_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_print_view = findViewById(R.id.tv_today_temp);

        CurrentLocation location = getCurrentLocation();
        getWeatherInfo(location.getLat(),location.getLon() );

    }



    public CurrentLocation getCurrentLocation(){
        CurrentLocation currentLocation = new CurrentLocation();
        currentLocation.setLat(33.441792);
        currentLocation.setLon(-94.037689);
        return currentLocation;
    }

    //public getLastLocation(){


    //}

    public void getWeatherInfo(Double lat, Double lon){
        OneClassRequest request = new OneClassRequest();
        request.setAppid("1bd1e5a422c4bc54365d73b8b8bf0b31");
        request.setExclude("hourly,minutely");
        request.setLat(lat);
        request.setLon(lon);

        Call<OneClassResponse>responseCall =  ApiClient.apiInterface().getWeatherByLocation(request.getLon(),request.getLat(),request.getAppid(),request.getExclude());
        Toast.makeText(MainActivity.this, "APi Hit", Toast.LENGTH_SHORT).show();
        responseCall.enqueue(new Callback<OneClassResponse>() {
            @Override
            public void onResponse(Call<OneClassResponse> call, Response<OneClassResponse> response) {
                tv_print_view.setText(response.body().getLat().toString());
                Toast.makeText(MainActivity.this, "Successfully triggered", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<OneClassResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
