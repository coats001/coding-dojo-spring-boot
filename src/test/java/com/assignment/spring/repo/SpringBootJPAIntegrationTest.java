package com.assignment.spring.repo;

import com.assignment.spring.WeatherApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    private WeatherRepository weatherRepository;

    @Test
    public void givenWeatherEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemperature(250.0);
        weatherEntity.setCity("Amsterdam");
        weatherEntity.setCountry("NL");

        WeatherEntity savedWeatherEntity = weatherRepository
                .save(weatherEntity);

        WeatherEntity foundWeatherEntity = weatherRepository
                .findById(savedWeatherEntity.getId()).get();

        assertNotNull(foundWeatherEntity);
        assertEquals(savedWeatherEntity.getCity(), foundWeatherEntity.getCity());
        assertEquals(savedWeatherEntity.getCountry(), foundWeatherEntity.getCountry());
        assertEquals(savedWeatherEntity.getTemperature(), foundWeatherEntity.getTemperature());

    }
}
