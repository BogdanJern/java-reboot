package ru.sberbank.edu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.PI;

/**
 * Geo position.
 */
public class GeoPosition {
    /**
     * Широта в радианах.
     */
    private final double latitude;

    /**
     * Долгота в радианах.
     */
    private final double longitude;

    private final String PATTERN = "^(-?)([0-9]{1,3})(\\(([0-9]{1,2})'([0-9]{1,2})''\\))?$";

    /**
     * Ctor.
     *
     * @param latitudeGradus  - latitude in gradus
     * @param longitudeGradus - longitude in gradus
     *                        Possible values: 55, 55(45'07''), 59(57'00'')
     */
    public GeoPosition(String latitudeGradus, String longitudeGradus) {
        latitude = gradus(latitudeGradus);
        longitude = gradus(longitudeGradus);
    }

    public double gradus(String gradus) {
        double radGrad, radMinute = 0.0, radSeconds = 0.0;
        Pattern regex = Pattern.compile(PATTERN);
        Matcher matcher = regex.matcher(gradus);

        if(!matcher.find()){
            throw new IllegalArgumentException("");
        }

        String strSign = matcher.group(1);
        String strGrad = matcher.group(2);
        String strMinute = matcher.group(4);
        String strSecond = matcher.group(5);

        radGrad = Double.parseDouble(strGrad);

        radGrad = radGrad * PI / 180;

        if (strMinute != null && !strMinute.equals("00") ){
            radGrad = radGrad + ( Double.parseDouble(strMinute) * PI / 180 / 60.0 );
        }

        if (strSecond != null && !strSecond.equals("00") ){
            radGrad = radGrad + ( Double.parseDouble(strSecond) * PI / 180 / 3600.0 );
        }

        if(strSign.equals("-")){
            radGrad = radGrad * -1.0;
        }

        return radGrad;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}