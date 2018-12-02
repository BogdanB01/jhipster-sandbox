package com.taip.smart.city.web.rest;


import com.taip.smart.city.control.service.WeatherService;
import com.taip.smart.city.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Weather getCurrentWeather() {
        return weatherService.getCurrentWeather();
    }

}
