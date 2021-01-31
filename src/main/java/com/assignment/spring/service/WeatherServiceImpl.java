package com.assignment.spring.service;

import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.client.WeatherServiceClient;
import com.assignment.spring.repo.WeatherEntity;
import com.assignment.spring.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {
    private final WeatherServiceClient weatherServiceClient;

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherServiceClient weatherServiceClient, WeatherRepository weatherRepository) {
        this.weatherServiceClient = weatherServiceClient;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public WeatherEntity getWeatherByCity(String cityId) {
        return mapper(weatherServiceClient.getWeatherData(cityId));
    }

    private WeatherEntity mapper(WeatherResponse response) {

        WeatherEntity entity = new WeatherEntity();
        entity.setCity(response.getName());
        entity.setCountry(response.getSys().getCountry());
        entity.setTemperature(response.getMain().getTemp());

        return weatherRepository.save(entity);
    }
}
