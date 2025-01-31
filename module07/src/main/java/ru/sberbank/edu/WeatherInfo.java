package ru.sberbank.edu;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    @JsonProperty("name")
    private String city;

    /**
     * Short weather description
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * Temperature.
     */
    private double temperature;

    /**
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * Wind speed.
     */
    private double windSpeed;

    /**
     * Pressure.
     */
    private double pressure;

    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private final LocalDateTime expiryTime;

    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("wind")
    private Wind wind;

    public WeatherInfo() {
        this.expiryTime = LocalDateTime.now();
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    @JsonGetter
    public String getCity() {
        return city;
    }

    /**
     * Gets short description.
     *
     * @return the short description
     */
    @JsonGetter
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    @JsonGetter
    public String getDescription() {
        return description;
    }

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    @JsonGetter
    public double getTemperature() {
        return temperature;
    }

    /**
     * Gets feels like temperature.
     *
     * @return the feels like temperature
     */
    @JsonGetter
    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    /**
     * Gets wind speed.
     *
     * @return the wind speed
     */
    @JsonGetter
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Gets pressure.
     *
     * @return the pressure
     */
    @JsonGetter
    public double getPressure() {
        return pressure;
    }

    /**
     * Gets expiry time.
     *
     * @return the expiry time
     */
    @JsonGetter
    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setWeather(List<Weather> weather) {
        this.shortDescription = weather.get(0).main;
        this.description = weather.get(0).description;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" + "city='" + city + '\'' + ", shortDescription='" + shortDescription + '\''
                + ", description='" + description + '\'' + ", temperature=" + temperature + ", feelsLikeTemperature="
                + feelsLikeTemperature + ", windSpeed=" + windSpeed + ", pressure=" + pressure + ", expiryTime="
                + expiryTime + '}';
    }

    public class Main {

        /**
         * The Temp.
         */
        @JsonProperty("temp")
        public double temp;
        /**
         * The Feels like.
         */
        @JsonProperty("feels_like")
        public double feelsLike;
        /**
         * The Pressure.
         */
        @JsonProperty("pressure")
        public double pressure;

        /**
         * Gets temp.
         *
         * @return the temp
         */
        @JsonGetter
        public double getTemp() {
            return temp;
        }

        /**
         * Gets feels like.
         *
         * @return the feels like
         */
        @JsonGetter
        public double getFeelsLike() {
            return feelsLike;
        }

        /**
         * Gets pressure.
         *
         * @return the pressure
         */
        @JsonGetter
        public double getPressure() {
            return pressure;
        }

        /**
         * Sets temp.
         *
         * @param temp the temp
         */
        public void setTemp(double temp) {
            WeatherInfo.this.temperature = temp;
        }

        /**
         * Sets feels like.
         *
         * @param feelsLike the feels like
         */
        public void setFeelsLike(double feelsLike) {
            WeatherInfo.this.feelsLikeTemperature = feelsLike;
        }

        /**
         * Sets pressure.
         *
         * @param pressure the pressure
         */
        public void setPressure(double pressure) {
            WeatherInfo.this.pressure = pressure;
        }
    }

    public static class Weather {

        /**
         * Instantiates a new Weather.
         */
        public Weather() {

        }

        @JsonProperty("main")
        private String main;
        @JsonProperty("description")
        private String description;

        /**
         * Gets main.
         *
         * @return the main
         */
        @JsonGetter
        public String getMain() {
            return main;
        }

        /**
         * Gets description.
         *
         * @return the description
         */
        @JsonGetter
        public String getDescription() {
            return description;
        }

    }

    /**
     * The type Wind.
     */
    public class Wind {

        /**
         * The Speed.
         */
        @JsonProperty("speed")
        public double speed;

        /**
         * Gets speed.
         *
         * @return the speed
         */
        @JsonGetter
        public double getSpeed() {
            return speed;
        }

        /**
         * Sets speed.
         *
         * @param speed the speed
         */
        public void setSpeed(double speed) {
            WeatherInfo.this.windSpeed = speed;
        }
    }
}
