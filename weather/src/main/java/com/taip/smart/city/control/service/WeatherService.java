package com.taip.smart.city.control.service;

import com.taip.smart.city.domain.Weather;

public interface WeatherService extends CrudService<Weather> {

    Weather getCurrentWeather();
}
