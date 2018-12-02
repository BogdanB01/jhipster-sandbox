package com.taip.smart.city.config;

import com.taip.smart.city.control.client.pojo.OpenWeatherResponse;
import com.taip.smart.city.domain.Weather;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(OpenWeatherResponse.class, Weather.class).addMappings(mapper -> {
            mapper.map(src -> src.getMain().getHumidity(), Weather::setHumidity);
            mapper.map(src -> src.getMain().getPressure(), Weather::setHumidity);
            mapper.map(src -> src.getMain().getTemp(), Weather::setTemperature);
            mapper.map(src -> src.getMain().getTempMax(), Weather::setMaximumTemperature);
            mapper.map(src -> src.getMain().getTempMin(), Weather::setMinimumTemperature);
            mapper.map(src -> src.getWind().getDeg(), Weather::setWindDegree);
            mapper.map(src -> src.getWind().getSpeed(), Weather::setWindSpeed);
        });
        return modelMapper;
    }

}
