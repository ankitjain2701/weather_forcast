package com.demo.weather_forcast.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OneClassResponse {
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("timezone_offset")
    private Integer timezone_offset;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;
    @SerializedName("current")
    private Object current;
    @SerializedName("daily")
    private List<Object> daily;

    public Object getCurrent() {
        return current;
    }

    public void setCurrent(Object current) {
        this.current = current;
    }

    public List<Object> getDaily() {
        return daily;
    }

    public void setDaily(List<Object> daily) {
        this.daily = daily;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(Integer timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
