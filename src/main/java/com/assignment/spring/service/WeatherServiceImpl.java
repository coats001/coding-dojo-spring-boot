package com.assignment.spring.service;

import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.client.WeatherServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private WeatherServiceClient weatherServiceClient;

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return weatherServiceClient.getWeatherData(cityId);
    }
}
