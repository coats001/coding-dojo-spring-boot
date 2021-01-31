package com.assignment.spring.client;

import com.assignment.spring.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeatherServiceClient {
    @Value("${weather.url}")
    private String urlWithPlaceholdeer;

    public WeatherResponse getWeatherData(String city) {

        String urlWithCity = String.format(urlWithPlaceholdeer, city);

        return WebClient.create()
                .get()
                .uri(urlWithCity)
                .retrieve()
                .bodyToMono(WeatherResponse.class).block();

    }
}
