package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        GeoPosition pos = new GeoPosition("-55(45'07'')","59");
        System.out.println(pos.toString());
        CityInfo city = new CityInfo("Kasimov", pos);
        System.out.println(city.toString());
    }
}
