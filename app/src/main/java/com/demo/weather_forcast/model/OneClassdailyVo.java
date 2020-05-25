package com.demo.weather_forcast.model;

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
    private Long dew_point;
    private Long wind_speed;
    private Long wind_deg;
    private OneClassCurrntWeatherVo weather;
    private Long clouds;
    private Long rain;
    private Long uvi;

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

    public OneClassCurrntWeatherVo getWeather() {
        return weather;
    }

    public void setWeather(OneClassCurrntWeatherVo weather) {
        this.weather = weather;
    }

    public Long getClouds() {
        return clouds;
    }

    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    public Long getRain() {
        return rain;
    }

    public void setRain(Long rain) {
        this.rain = rain;
    }

    public Long getUvi() {
        return uvi;
    }

    public void setUvi(Long uvi) {
        this.uvi = uvi;
    }
}
