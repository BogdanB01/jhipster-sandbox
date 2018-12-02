package com.taip.smart.city.control.service.impl;


import com.taip.smart.city.control.client.OpenWeatherClient;
import com.taip.smart.city.control.client.pojo.OpenWeatherResponse;
import com.taip.smart.city.control.service.WeatherService;
import com.taip.smart.city.domain.Weather;
import com.taip.smart.city.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private OpenWeatherClient openWeatherClient;

    @Override
    public Weather save(Weather entity) {
        return weatherRepository.save(entity);
    }

    @Override
    public Optional<Weather> findById(Long id) {
        return weatherRepository.findById(id);
    }

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        weatherRepository.deleteById(id);
    }

    @Override
    public Weather getCurrentWeather() {
        Optional<Weather> lastSavedWeather = weatherRepository.findTopByOrderByTimestampDesc();

        if (lastSavedWeather.isPresent()) {
            Weather dbWeather = lastSavedWeather.get();
            Date lastHour = new Date(System.currentTimeMillis() - 3600 * 1000);

            if (!dbWeather.getTimestamp().before(lastHour)) {
                return dbWeather;
            }
        }
        Weather weather = getWeatherFromOpenWeatherApi();
        weather.setTimestamp(new Date());
        weatherRepository.save(weather);
        return weather;

    }

    private Weather getWeatherFromOpenWeatherApi() {
        OpenWeatherResponse openWeatherResponse = openWeatherClient.getCurrentWeather();
        Weather weather = map(openWeatherResponse);
        return weather;
    }


    private Weather map(OpenWeatherResponse openWeatherResponse) {
        Weather weather = new Weather();

        weather.setHumidity(openWeatherResponse.getMain().getHumidity());
        weather.setMinimumTemperature(openWeatherResponse.getMain().getTempMin());
        weather.setMaximumTemperature(openWeatherResponse.getMain().getTempMax());
        weather.setTemperature(openWeatherResponse.getMain().getTemp());

        return weather;
    }
}
