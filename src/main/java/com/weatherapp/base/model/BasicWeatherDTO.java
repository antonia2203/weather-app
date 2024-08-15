package com.weatherapp.base.model;

public class BasicWeatherDTO {
    private String city;
    private Double temperature;

    public BasicWeatherDTO() {
        // Default constructor
    }

    public BasicWeatherDTO(String city, Double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "BasicWeatherDTO{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
