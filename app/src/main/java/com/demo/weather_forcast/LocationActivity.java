package com.demo.weather_forcast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.weather_forcast.Adapter.HorizontalAdapter;
import com.demo.weather_forcast.Adapter.MyAdapter;
import com.demo.weather_forcast.Api.ApiClient;
import com.demo.weather_forcast.R;
import com.demo.weather_forcast.model.OneClassRequest;
import com.demo.weather_forcast.model.OneClassResponse;
import com.demo.weather_forcast.model.OneClassdailyVo;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class LocationActivity extends AppCompatActivity {

    ListView listView;
    GridView GridListView;
    MyAdapter myAdapteradapter;
    int PERMISSION_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
    TextView tv_address;
    TextView tv_updated_at;
    TextView tv_temp;
    TextView tv_sunset_temp;
    TextView tv_sunrise_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_address = (TextView) findViewById(R.id.address);
        tv_updated_at= (TextView) findViewById(R.id.updated_at);
        tv_temp = (TextView) findViewById(R.id.temp);
        tv_sunset_temp= (TextView) findViewById(R.id.sunset_temp);
        tv_sunrise_temp= (TextView) findViewById(R.id.sunrise_temp);
        //listView=(ListView) findViewById(R.id.listview_item);
        //GridListView=(GridView)findViewById(R.id.listview_item);


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        getLastLocation();
    }
    @SuppressLint("MissingPermission")
    private void getLastLocation(){
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {
                                    getWeatherInfo(location.getLatitude(),location.getLongitude());

                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData(){

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            getWeatherInfo(mLastLocation.getLatitude(),mLastLocation.getLongitude());
        }
    };

    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID

        );
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }

    }

    public void getWeatherInfo(final Double lat, final Double lon){
        final OneClassRequest request = new OneClassRequest();
        request.setAppid("1bd1e5a422c4bc54365d73b8b8bf0b31");
        request.setExclude("hourly,minutely");
        request.setLat(lat);
        request.setLon(lon);

        Call<OneClassResponse> responseCall =  ApiClient.apiInterface().getWeatherByLocation(request.getLon(),request.getLat(),request.getAppid(),request.getExclude());
        Toast.makeText(getApplicationContext(), "APi Hit", Toast.LENGTH_SHORT).show();
        responseCall.enqueue(new Callback<OneClassResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<OneClassResponse> call, Response<OneClassResponse> response) {

                tv_address.setText(response.body().getTimezone());

               // Date date = new Date(response.body().getCurrent().getDt());
                Long update=response.body().getCurrent().getDt();
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yy hh:mm a", Locale.ENGLISH).format(new Date(update * 1000));


                tv_updated_at.setText(updatedAtText);


                Double temp=response.body().getCurrent().getTemp();
                Double cal_temp=temp-273.15;
                DecimalFormat precision = new DecimalFormat("0.0");

                tv_temp.setText(precision.format(cal_temp).toString()+"°C");

                Long sunrise=response.body().getCurrent().getSunrise();
                String sunrise_text = "Sunrise: " + new SimpleDateFormat(" hh:mm a", Locale.ENGLISH).format(new Date( sunrise* 1000));
                tv_sunrise_temp.setText(sunrise_text);

                Long sunset=response.body().getCurrent().getSunset();
                String sunset_text = "Sunrise: " + new SimpleDateFormat(" hh:mm a", Locale.ENGLISH).format(new Date( sunset* 1000));
                tv_sunset_temp.setText(sunset_text);

               // tv_sunset_temp.setText("Sunset:"+response.body().getCurrent().getSunset().toString());

                //myAdapteradapter= new MyAdapter(getApplicationContext(), response.body().getDaily());
               // listView.setAdapter(myAdapteradapter);
                //GridListView.setAdapter(myAdapteradapter);

                RecyclerView list=(RecyclerView) findViewById(R.id.list);
                list.setLayoutManager(new LinearLayoutManager(LocationActivity.this,LinearLayoutManager.HORIZONTAL,false));
                list.setAdapter(new HorizontalAdapter(getApplicationContext(),response.body().getDaily()));


                Toast.makeText(getApplicationContext(), "Successfully triggered", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<OneClassResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
