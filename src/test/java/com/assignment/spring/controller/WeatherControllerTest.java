package com.assignment.spring.controller;

import com.assignment.spring.repo.WeatherEntity;
import com.assignment.spring.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService service;

    @Test
    public void when_called_with_city_name_will_return_weatherdata()

            throws Exception {

        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity("Amsterdam");
        weatherEntity.setCountry("NL");
        weatherEntity.setTemperature(260.0);
        weatherEntity.setId(1);

        given(service.getWeatherByCity("Amsterdam")).willReturn(weatherEntity);

        mvc.perform(get("/weather?city=Amsterdam")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.city", notNullValue()))
                .andExpect(jsonPath("$.country", notNullValue()))
                .andExpect(jsonPath("$.temperature", notNullValue()));
    }

}
