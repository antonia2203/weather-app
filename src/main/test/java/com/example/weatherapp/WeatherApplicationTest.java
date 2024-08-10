/*
package main.test.java.com.example.weatherapp;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.weatherapp.base.model.Weather;
import com.weatherapp.base.model.WeatherCondition;
import com.weatherapp.base.repository.WeatherRepository;
import com.weatherapp.base.service.WeatherService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class WeatherApplicationTest {

    private WeatherRepository weatherRepository;
    private WeatherService weatherService;

    @Before
    public void setUp() {
        // Create a mock WeatherRepository
        weatherRepository = Mockito.mock(WeatherRepository.class);

        // Inject the mock repository into WeatherService using constructor injection
        weatherService = new WeatherService(weatherRepository);
    }

    @Test
    public void testGetWeatherByCityExists() {
        // Given
        String city = "New York";
        Weather weather = new Weather(null, city, WeatherCondition.SUNNY, 25.0);
        Mockito.when(weatherRepository.findByCity(city)).thenReturn(Optional.of(weather));

        // When
        Weather result = weatherService.getWeatherByCity(city);

        // Then
        assertNotNull(result);
        assertEquals(city, result.getCity());
        assertEquals(WeatherCondition.SUNNY, result.getWeatherCondition());
        assertEquals(25.0, result.getTemperature(), 0.0001); // Using delta for double comparison
    }

    @Test
    public void testGetWeatherByCityDoesNotExist() {
        // Given
        String city = "Los Angeles";
        Mockito.when(weatherRepository.findByCity(city)).thenReturn(Optional.empty());

        // When
        Weather result = weatherService.getWeatherByCity(city);

        // Then
        assertNull(result);
    }
}
*/
