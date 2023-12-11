package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        WeatherProvider provider = new WeatherProvider();
        provider.get("Moscow");
    }
}
