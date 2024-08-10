package com.weatherapp.base.repository;

import com.weatherapp.base.model.WeatherDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface WeatherRepository extends JpaRepository<WeatherDTO, Long> {

    Optional<WeatherDTO> findByCity(String city);
}
