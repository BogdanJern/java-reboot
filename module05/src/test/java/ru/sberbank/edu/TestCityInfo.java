package ru.sberbank.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestCityInfo {
    @Test
    public void CityInfoTest(){
        GeoPosition pos = new GeoPosition("54(43'11'')","41(23'50'')");
        Assertions.assertEquals(pos.getLatitude(), 0.9550393185544861);
        Assertions.assertEquals(pos.getLongitude(), 0.7225178289575414);

        pos = new GeoPosition("-38(54'12'')","-67(12'46'')");
        Assertions.assertEquals(pos.getLatitude(), -0.6789912566675272);
        Assertions.assertEquals(pos.getLongitude(), -1.1730842716334997);
    }

}
