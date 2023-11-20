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
    private double latitude;

    /**
     * Долгота в радианах.
     */
    private double longitude;

    private final String PATTERN = "^(-?)([0-9]{1,3})(\\(([0-6]{1,2})\'([0-9]{1,2})\'\'\\))?$";

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
        double radGrad = 0.0, minutes = 0.0, seconds = 0.0;
        Pattern regex = Pattern.compile(PATTERN);
        Matcher matcher = regex.matcher(gradus);
        if (!matcher.find()) {

        }

        radGrad = Double.parseDouble(matcher.group(2));
        if(matcher.group(1) != ""){
            radGrad = radGrad * -1.0;
        }
        radGrad = radGrad * PI / 180;

        if (matcher.group(4) != null && matcher.group(4) != "00" ){
            radGrad = radGrad + ( Double.parseDouble(matcher.group(2)) * PI / 180 / 60.0 );
        }
        if (matcher.group(5) != null && matcher.group(5) != "00" ){
            radGrad = radGrad + ( Double.parseDouble(matcher.group(2)) * PI / 180 / 3600.0 );
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