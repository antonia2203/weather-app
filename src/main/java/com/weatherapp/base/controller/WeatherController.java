package com.weatherapp.base.controller;

import com.weatherapp.base.model.WeatherDTO;
import com.weatherapp.base.service.impl.WeatherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    // Constructor Injection
    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    // Get all weather entries
    @GetMapping
    @Operation(summary = "Retrieve all weather entries")
    public List<WeatherDTO> getAllWeather() {
        return weatherService.getAllWeather();
    }

    // Get weather by City
    @GetMapping("/city/{city}")
    @Operation(summary = "Find weather by city")
    public ResponseEntity<WeatherDTO> getWeatherByCity(@PathVariable String city) {
        WeatherDTO weather = weatherService.getWeatherByCity(city);
        if (weather != null) {
            return ResponseEntity.ok(weather);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get weather by ID
    @GetMapping("/{id}")
    @Operation(summary = "Find weather by ID")
    public ResponseEntity<WeatherDTO> getWeatherById(@PathVariable Long id) {
        WeatherDTO weather = weatherService.getWeatherById(id);
        if (weather != null) {
            return ResponseEntity.ok(weather);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add new weather entry
    @PostMapping
    @Operation(summary = "Add a new weather entry")
    public ResponseEntity<WeatherDTO> addWeather(@RequestBody WeatherDTO weather) {
        weatherService.addWeather(weather);
        return ResponseEntity.status(HttpStatus.CREATED).body(weather);
    }

    // Update existing weather entry
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing weather entry by ID")
    public ResponseEntity<WeatherDTO> updateWeather(@PathVariable Long id, @RequestBody WeatherDTO weather) {
        weatherService.updateWeather(id, weather);
        return ResponseEntity.ok(weather);
    }

    // Delete weather entry
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a weather entry by ID")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }

    // Add mock data
    @PostMapping("/addMockData")
    @Operation(summary = "Add mock data")
    public ResponseEntity<Void> addMockData() {
        weatherService.addMockData();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}