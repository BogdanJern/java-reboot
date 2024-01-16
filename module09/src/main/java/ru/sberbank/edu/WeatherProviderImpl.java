package ru.sberbank.edu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Weather provider
 */
public class WeatherProviderImpl implements WeatherProvider {

    private RestTemplate restTemplate;

    private String appKey;

    //@Autowired
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherProviderImpl(String appKey) {
        this.appKey = appKey;
    }

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    @Override
    public WeatherInfo get(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "&appid=" +
                appKey;
        try {
            return restTemplate.getForObject(new URI(url), WeatherInfo.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (HttpClientErrorException e) {
            return null;
        }
    }
}
