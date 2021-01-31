package com.assignment.spring.controller;

import com.assignment.spring.WeatherEntity;
import com.assignment.spring.WeatherRepository;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping(value = "/weather")
    public WeatherEntity weather(@RequestParam String city) {
        return mapper(weatherService.getWeatherByCityId(city));
    }

    private WeatherEntity mapper(WeatherResponse response) {

        WeatherEntity entity = new WeatherEntity();
        entity.setCity(response.getName());
        entity.setCountry(response.getSys().getCountry());
        entity.setTemperature(response.getMain().getTemp());

        return weatherRepository.save(entity);
    }
}
