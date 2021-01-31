package com.assignment.spring.client;

import com.assignment.spring.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeatherServiceClient {
    @Value("weather.url")
    private String url;

    public WeatherResponse getWeatherData(String city) {
        return WebClient.create()
                .get()
                .uri("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=664a438da5484e3beaf3509a10b017a7")
                .retrieve()
                .bodyToMono(WeatherResponse.class).block();

    }
}
