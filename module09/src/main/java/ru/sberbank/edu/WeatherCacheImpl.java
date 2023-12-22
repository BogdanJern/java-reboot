package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Weather cache.
 */
@Component
public class WeatherCacheImpl implements WeatherCache{

    private final Map<String, WeatherInfo> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    /**
     * Default constructor.
     */
    @Autowired
    public WeatherCacheImpl(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Get ACTUAL weather info for current city or null if current city not found.
     * If cache doesn't contain weather info OR contains NOT ACTUAL info then we should download info
     * If you download weather info then you should set expiry time now() plus 5 minutes.
     * If you can't download weather info then remove weather info for current city from cache.
     *
     * @param city - city
     * @return actual weather info
     */
    @Override
    public synchronized WeatherInfo getWeatherInfo(String city) {
        if (!cache.containsKey(city) || cache.get(city).getExpiryTime()
                .isBefore(LocalDateTime.now().minusMinutes(5))) {
            WeatherInfo weatherInfo = weatherProvider.get(city);
            if (weatherInfo == null) {
                removeWeatherInfo(city);
            } else {
                cache.put(city, weatherInfo);
            }
        }
        return cache.get(city);
    }

    /**
     * Remove weather info from cache.
     **/
    public void removeWeatherInfo(String city) {
        if (!cache.containsKey(city)) {
            return;
        }
        cache.remove(city);
    }
}