package com.taip.smart.city.control.client;

import com.taip.smart.city.control.client.pojo.OpenWeatherResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OpenWeatherClientImpl implements OpenWeatherClient {

    @Override
    public OpenWeatherResponse getCurrentWeather() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_API_URL)
                .queryParam("id", CITY_ID)
                .queryParam("APPID", API_KEY);

        HttpEntity<?> entity = new HttpEntity<>(headers);


        HttpEntity<OpenWeatherResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                OpenWeatherResponse.class);

        OpenWeatherResponse openWeatherResponse = response.getBody();

        return openWeatherResponse;
    }

    @Override
    public void getForecast() {

    }
}
