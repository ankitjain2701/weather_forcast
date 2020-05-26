package com.demo.weather_forcast.model;

import java.util.List;

public class OneClassdailyVo {
    private Long dt;

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

    public OneClassTempVo getTemp() {
        return Temp;
    }

    public void setTemp(OneClassTempVo temp) {
        Temp = temp;
    }

    private Long sunrise;
    private Long sunset;
    private OneClassTempVo Temp;
    private OneClassfeels_like feels_like;

    public OneClassfeels_like getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(OneClassfeels_like feels_like) {
        this.feels_like = feels_like;
    }
    private Long pressure;
    private Long humidity;
    private Double dew_point;
    private Double wind_speed;
    private Long wind_deg;
    private List<OneClassCurrntWeatherVo> weather;
    private Long clouds;
    private Double rain;
    private Double uvi;

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

    public Double getDew_point() {
        return dew_point;
    }

    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
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

    public Long getClouds() {
        return clouds;
    }

    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }
}
