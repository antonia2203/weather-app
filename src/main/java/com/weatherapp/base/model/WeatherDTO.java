package com.weatherapp.base.model;

import jakarta.persistence.*;

@Entity
@Table(name = "weather")
public class WeatherDTO extends BasicWeatherDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_condition", nullable = false)
    private WeatherCondition weatherCondition;

    // Default constructor for JPA
    public WeatherDTO() {
        super();
    }

    public WeatherDTO(Long id, String city, WeatherCondition weatherCondition, Double temperature) {
        super(city, temperature);
        this.id = id;
        this.weatherCondition = weatherCondition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    @Override
    public String toString() {
        return "WeatherDTO{" +
                "id=" + id +
                ", city='" + getCity() + '\'' +
                ", weatherCondition=" + weatherCondition +
                ", temperature=" + getTemperature() +
                '}';
    }
}
