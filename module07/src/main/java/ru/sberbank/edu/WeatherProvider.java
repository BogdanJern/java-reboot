package ru.sberbank.edu;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherProvider {

    private static final String API_KEY = "70340e86c86d508b623dd9d9f495a714";

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        try {
            return restTemplate.getForObject(new URI(url), WeatherInfo.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (HttpClientErrorException e) {
            return null;
        }
    }
}
