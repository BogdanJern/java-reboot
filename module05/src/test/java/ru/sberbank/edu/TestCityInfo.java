package ru.sberbank.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestCityInfo {
    @Test
    public void CityInfoTest(){

        GeoPosition posKas = new GeoPosition("54(57'00'')","41(23'50'')");
        GeoPosition posOther = new GeoPosition("25(11'14'')","14(12'22'')");

        CityInfo city = new CityInfo("Kasimov",posKas);

        Assertions.assertEquals(city.getName(),"Kasimov");
        Assertions.assertNotEquals(city.getName(),"Omsk");

        Assertions.assertEquals(city.getPosition(),posKas);
        Assertions.assertNotEquals(city.getPosition(),posOther);
    }

}
