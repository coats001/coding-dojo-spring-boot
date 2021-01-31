package com.assignment.spring.controller;

import com.assignment.spring.repo.WeatherEntity;
import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;



    @GetMapping(value = "/weather")
    public WeatherEntity weather(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }


}
