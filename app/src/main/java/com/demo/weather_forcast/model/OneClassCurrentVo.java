package com.demo.weather_forcast.model;

import java.util.List;

public class OneClassCurrentVo {
private Long dt;
private Long sunrise;
private Long sunset;
private Long temp;

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    public Long getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Long feels_like) {
        this.feels_like = feels_like;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getDew_point() {
        return dew_point;
    }

    public void setDew_point(Long dew_point) {
        this.dew_point = dew_point;
    }

    public Long getUvi() {
        return uvi;
    }

    public void setUvi(Long uvi) {
        this.uvi = uvi;
    }

    public Long getClouds() {
        return clouds;
    }

    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Long getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Long wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Long getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Long wind_deg) {
        this.wind_deg = wind_deg;
    }

    public List<OneClassCurrntWeatherVo> getWeather() {
        return weather;
    }

    public void setWeather(List<OneClassCurrntWeatherVo> weather) {
        this.weather = weather;
    }

    private Long feels_like;
private Long pressure;
private Long humidity;
private Long dew_point;
private Long uvi;
private Long clouds;
private Long visibility;
private Long wind_speed;
private Long wind_deg;
private List<OneClassCurrntWeatherVo> weather;
}
