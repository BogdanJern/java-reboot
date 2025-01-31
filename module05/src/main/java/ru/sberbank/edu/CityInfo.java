package ru.sberbank.edu;

/**
 * City info
 */
public class CityInfo {

    private final String name;
    private final GeoPosition position;

    /**
     * Ctor.
     *
     * @param name     - city name
     * @param position - position
     */
    public CityInfo(String name, GeoPosition position) {
        if (position == null){
            throw new IllegalArgumentException("Данные местоположения пусты");
        }
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    public String getName() {
        return name;
    }

    public GeoPosition getPosition() {
        return position;
    }
}