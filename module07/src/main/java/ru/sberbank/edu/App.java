package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        WeatherProvider provider = new WeatherProvider();

        WeatherCache cache = new WeatherCache(provider);
        System.out.println(cache.getWeatherInfo("Moscow"));

        System.out.println(cache.getWeatherInfo("Moscow"));
    }
}
