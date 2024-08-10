package com.weatherapp.base.service.impl;


import com.weatherapp.base.repository.WeatherRepository;
import org.springframework.stereotype.Service;
import com.weatherapp.base.model.WeatherCondition;
import com.weatherapp.base.model.WeatherDTO;

import java.util.List;
import java.util.Optional;




@Service
public class WeatherServiceImpl {

    private final WeatherRepository weatherRepository;

    // Constructor Injection
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherDTO getWeatherByCity(String city) {
        if (city == null || city.isEmpty()) {
            return null;
        }

        Optional<WeatherDTO> weather = weatherRepository.findByCity(city);
        return weather.orElse(null);
    }

    public WeatherDTO getWeatherById(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    public List<WeatherDTO> getAllWeather() {
        return weatherRepository.findAll();
    }

    public void addWeather(WeatherDTO weather) {
        weatherRepository.save(weather);
    }

    public void updateWeather(Long id, WeatherDTO weather) {
        if (weatherRepository.existsById(id)) {
            weather.setId(id);
            weatherRepository.save(weather);
        }
    }

    public void deleteWeather(Long id) {
        weatherRepository.deleteById(id);
    }

    public void addMockData() {
        weatherRepository.save(new WeatherDTO(null, "New York", WeatherCondition.SUNNY, 25.00));
        weatherRepository.save(new WeatherDTO(null, "Los Angeles", WeatherCondition.CLOUDY, 22.00));
        weatherRepository.save(new WeatherDTO(null, "Chicago", WeatherCondition.RAINY, 18.00));
        weatherRepository.save(new WeatherDTO(null, "Constanta", WeatherCondition.SUNNY, 32.00));
        weatherRepository.save(new WeatherDTO(null, "Houston", WeatherCondition.THUNDERSTORMS, 28.00));
        weatherRepository.save(new WeatherDTO(null, "Phoenix", WeatherCondition.SUNNY, 35.00));
    }
}
