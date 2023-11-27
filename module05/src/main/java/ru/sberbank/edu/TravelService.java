package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

/**
 * Travel Service.
 */
public class TravelService {

    // do not change type
    private final List<CityInfo> cities = new ArrayList<>();

    /**
     * Append city info.
     *
     * @param cityInfo - city info
     * @throws IllegalArgumentException if city already exists
     */
    public void add(CityInfo cityInfo) {
        cities.add(cityInfo);
    }

    /**
     * remove city info.
     *
     * @param cityName - city name
     * @throws IllegalArgumentException if city doesn't exist
     */
    public void remove(String cityName) {
        CityInfo city = findCityByName(cityName);
        cities.remove(city);
    }

    /**
     * Найти город по названию
     * @param cityName Название города
     * @return информация о найденном городе
     */
    private CityInfo findCityByName(String cityName){
        return cities.stream()
                .filter(city -> city.getName().equals(cityName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No city exist"));
    }

    /**
     * Get cities names.
     */
    public List<String> citiesNames() {
        return cities.stream().map(CityInfo::getName).toList();
    }

    /**
     * Get distance in kilometers between two cities.
     *
     * @param srcCityName  - source city
     * @param destCityName - destination city
     * @throws IllegalArgumentException if source or destination city doesn't exist.
     */
    public int getDistance(String srcCityName, String destCityName) {

        CityInfo srcCity = findCityByName(srcCityName);
        CityInfo destCity = findCityByName(destCityName);

        double cosScrLatitude = cos(srcCity.getPosition().getLatitude());
        double cosDestLatitude = cos(destCity.getPosition().getLatitude());

        double sinScrLatitude = sin(srcCity.getPosition().getLatitude());
        double sinDestLatitude = sin(destCity.getPosition().getLatitude());

        double delta = destCity.getPosition().getLongitude() - srcCity.getPosition().getLongitude();
        double cosDelta = cos(delta);
        double sinDelta = sin(delta);

        double y = sqrt((pow((cosScrLatitude * sinDelta),2)) + pow((cosScrLatitude * sinDestLatitude - sinScrLatitude * cosDestLatitude * cosDelta),2));

        double x = sinScrLatitude * sinDestLatitude + cosScrLatitude * cosDestLatitude * cosDelta;
        double atanDist = atan2(y,x);

        double dist = atanDist * 6371;
        return  (int) Math.round(dist);

    }

    /**
     * Get all cities near current city in radius.
     *
     * @param cityName - city
     * @param radius   - radius in kilometers for search
     * @throws IllegalArgumentException if city with cityName city doesn't exist.
     */
    public List<String> getCitiesNear(String cityName, int radius) {

        return cities.stream()
                .map(CityInfo::getName)
                .filter(name -> !name.equals(cityName))
                .filter(name -> this.getDistance(cityName, name) < radius)
                .toList();
    }
}
