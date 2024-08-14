package com.weatherapp.base.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "weather")

        @AttributeOverride(name = "city", column = @Column(name = "city", nullable = false))
        @AttributeOverride(name = "temperature", column = @Column(name = "temperature", nullable = false))
public class WeatherDTO extends BasicWeatherDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_condition", nullable = false)
    private WeatherCondition weatherCondition;

    public WeatherDTO() {
        // Default constructor for JPA
    }

    public WeatherDTO(Long id, String city, WeatherCondition weatherCondition, Double temperature) {
        super(city, temperature); // Call to the parent class constructor
        this.id = id;
        this.weatherCondition = weatherCondition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1 , max =100)
    @Column(name = "city")
    private String city;



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
