package com.example.demo.dto;

public class WeatherDto {

    private Long id;
    private String description;
    private Double temperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Double pressure;
    private Double airSpeed;
    private Double humidity;

    public WeatherDto(String description, Double temperature, Double minTemperature, Double maxTemperature, Double pressure, Double airSpeed, Double humidity) {
        this.description = description;
        this.temperature = temperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.pressure = pressure;
        this.airSpeed = airSpeed;
        this.humidity = humidity;
    }

    public WeatherDto() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(Double airSpeed) {
        this.airSpeed = airSpeed;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
