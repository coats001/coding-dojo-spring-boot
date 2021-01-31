package com.assignment.spring.service;

import com.assignment.spring.model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherByCityId(String cityId);
}
