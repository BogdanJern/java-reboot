package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        System.out.println(city.toString());
        travelService.add(city);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        System.out.println(city.toString());
        travelService.add(city);

        pos = new GeoPosition("68(58'00'')","33(05'00'')");
        city = new CityInfo("Murmansk", pos);
        System.out.println(city.toString());
        travelService.add(city);

        pos = new GeoPosition("55(45'21'')","37(37'04'')");
        city = new CityInfo("Moscow", pos);
        System.out.println(city.toString());
        travelService.add(city);

        System.out.println(travelService.getDistance("Kasimov","Murmansk"));
        System.out.println(travelService.getCitiesNear("Kasimov",1000).toString());
    }
}
