package ru.sberbank.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTravelService {

    @Test
    public void testAdd(){

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        travelService.add(city);

        Assertions.assertEquals(travelService.citiesNames().size(), 1);
        Assertions.assertNotEquals(travelService.citiesNames().size(), 2);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        travelService.add(city);

        Assertions.assertEquals(travelService.citiesNames().size(), 2);
        Assertions.assertNotEquals(travelService.citiesNames().size(), 1);

        Assertions.assertEquals(travelService.citiesNames().get(0),"Kasimov");
        Assertions.assertEquals(travelService.citiesNames().get(1),"Omsk");
    }
    @Test
    public void testRemove(){

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        travelService.add(city);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        travelService.add(city);

        pos = new GeoPosition("55(45'21'')","37(37'04'')");
        city = new CityInfo("Moscow", pos);
        travelService.add(city);

        Assertions.assertEquals(travelService.citiesNames().size(), 3);
        Assertions.assertEquals(travelService.citiesNames().get(0),"Kasimov");
        Assertions.assertEquals(travelService.citiesNames().get(1),"Omsk");
        Assertions.assertEquals(travelService.citiesNames().get(2),"Moscow");

        travelService.remove("Omsk");
        Assertions.assertEquals(travelService.citiesNames().size(), 2);
        Assertions.assertEquals(travelService.citiesNames().get(0),"Kasimov");
        Assertions.assertEquals(travelService.citiesNames().get(1),"Moscow");
    }

    @Test
    public void testCitiesNames(){

        List<String> names = new ArrayList<>();
        names.add("Kasimov");
        names.add("Omsk");
        names.add("Moscow");

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        travelService.add(city);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        travelService.add(city);

        pos = new GeoPosition("55(45'21'')","37(37'04'')");
        city = new CityInfo("Moscow", pos);
        travelService.add(city);

        Assertions.assertEquals(travelService.citiesNames(),names);

    }

    @Test
    public void testGetDistance(){

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        travelService.add(city);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        travelService.add(city);

        pos = new GeoPosition("55(45'21'')","37(37'04'')");
        city = new CityInfo("Moscow", pos);
        travelService.add(city);

        Assertions.assertEquals(travelService.getDistance("Kasimov","Moscow"),260);
        Assertions.assertEquals(travelService.getDistance("Moscow","Omsk"),2198);

    }

    @Test
    public void testGetCitiesNear(){

        TravelService travelService = new TravelService();

        GeoPosition pos = new GeoPosition("54(57'00'')","41(23'50'')");
        CityInfo city = new CityInfo("Kasimov", pos);
        travelService.add(city);

        pos = new GeoPosition("54(58'00'')","73(23'00'')");
        city = new CityInfo("Omsk", pos);
        travelService.add(city);

        pos = new GeoPosition("55(45'21'')","37(37'04'')");
        city = new CityInfo("Moscow", pos);
        travelService.add(city);

    }

}
