package com.assignment.spring.service;

import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repo.WeatherEntity;

public interface WeatherService {
    WeatherEntity getWeatherByCity(String cityId);
}
