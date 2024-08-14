package com.weatherapp.base.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "weather")
public class WeatherDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city", nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_condition", nullable = false)
    private WeatherCondition weatherCondition;

    @Column(name = "temperature", nullable = false)
    private Double temperature;

    // Default constructor for JPA
    public WeatherDTO() {
    }

    public WeatherDTO(Long id, String city, WeatherCondition weatherCondition, Double temperature) {
        this.id = id;
        this.city = city;
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherDTO{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", weatherCondition=" + weatherCondition +
                ", temperature=" + temperature +
                '}';
    }
}
